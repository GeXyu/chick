/*
 * $Id: HttpConnector.java, 2018年7月13日 下午1:15:14 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;
import cn.zzcode.common.HttpServletContext;
import cn.zzcode.core.api.Container;

/**
 * <p>
 * Title: HttpConnector
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月13日 下午1:15:14
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpConnector {

    private static ServletContext servletContext = new HttpServletContext();

    static int PORT = 8090;
    static int BUFFER_SIZE = 1024;
    static String CHARSET = "utf-8"; // 默认编码
    CharsetDecoder decoder; // 解码

    private ServerSocketChannel channel;
    private Selector selector;
    private ByteBuffer buffer;
    private Container container;

    public HttpConnector() {
        this.buffer = ByteBuffer.allocate(BUFFER_SIZE);
        this.decoder = Charset.forName(CHARSET).newDecoder();
        try {
            // 打开选择器
            this.selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单线程服务，通过单一个线程同时为多路复用IO流服务 1、此方式适合：IO密集型的操作：如代理服务. 2、相信大家写过：使用socket的聊天程序:
     * 即accept()一个socket后，new一个Thread为该socket服务， 此方式适合：CPU密集型的操作，如需要处理大量业务、计算
     *
     * @throws IOException
     */
    public void listen() throws IOException {
        openChannel();
        while (true) {
            regiester();
            process();
        }
    }

    /**
     * @throws IOException
     */
    private void regiester() throws IOException {
        // 非阻塞，没有连接，立即返回null，与socket.accept()方法(阻塞)不同，
        SocketChannel client = channel.accept();
        if (client != null) {
            // 设置非阻塞
            client.configureBlocking(false);
            // 将客户端channel注册到selector上
            client.register(selector, SelectionKey.OP_READ);
        }
    }

    /**
     * @throws IOException
     */
    private void openChannel() throws IOException {
        // 打开一个服务通道
        this.channel = ServerSocketChannel.open();
        // 绑定服务端口
        ServerSocket socket = channel.socket();
        socket.bind(new InetSocketAddress(PORT));
        // 使用非阻塞模式，使用多道io操作
        channel.configureBlocking(false);
    }

    /**
     * 遍历各客户端通道 select()阻塞到至少有一个通道在你注册的事件上就绪了 select(long timeout) 多设置一个阻塞时间(毫秒)
     * selectNow() 不阻塞，有无都返回。
     */
    private void process() throws IOException {

        if (selector.selectNow() > 0) {
            // 客户端channel的键集合
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();

                if (key.isReadable()) {
                    new ReadChannelHandle().run(key);
                } else if (key.isWritable()) {
                    new WriteChannelHandle().run(key);
                }
            }

        }
    }

    protected class ReadChannelHandle {

        /**
         * @throws IOException
         * @see java.lang.Runnable#run()
         */
        public void run(SelectionKey key) throws IOException {

            SocketChannel client = (SocketChannel) key.channel();
            buffer.clear();

            int c = 0;
            try {
                c = client.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (c > 0) {
                // flip方法将Buffer从写模式切换到读模式
                buffer.flip();
                CharBuffer charBuffer = decoder.decode(buffer);
                HttpRequest request = parseRequest(charBuffer);
                request.setByteBuffer(buffer);

                // String requstStr = charBuffer.toString();
                // System.out.println(requstStr);

                HttpResponse httpResponse = new HttpResponse();
                httpResponse.setBuffer(ByteBuffer.allocate(1024));

                getContainer().invoke(request, httpResponse);

                key.attach(httpResponse);
                // 改变自身关注事件，可以用位或操作|组合时间
                key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);

            } else {
                client.close();
            }
            buffer.clear();
        }

    }

    protected class WriteChannelHandle {

        /**
         * @throws IOException
         * @see java.lang.Runnable#run()
         */
        public void run(SelectionKey key) throws IOException {

            SocketChannel client = (SocketChannel) key.channel();

            HttpResponse httpResponse = (HttpResponse) key.attachment();
            ByteBuffer writerBuffer = httpResponse.getBuffer();
            writerBuffer.flip();
            String result = new String(writerBuffer.array(), "UTF-8").trim();

            StringBuffer buffer = new StringBuffer();
            buffer.append("HTTP/1.1 200 OK" + "\r\n");
            buffer.append("Connection: keep-alive" + "\r\n");
            buffer.append("Content-Type: " + httpResponse.getContentType() + "\r\n");
            buffer.append("Server: nest" + "\r\n");
            buffer.append("\r\n");
            buffer.append(result);

            ByteBuffer block = ByteBuffer.wrap(buffer.toString().getBytes());
            client.write(block);
            client.close();

        }

    }

    /**
     * @see cn.zzcode.core.api.Connector#setContainer(cn.zzcode.core.api.Container)
     */
    public void setContainer(Container container) {
        this.container = container;

    }

    /**
     * @see cn.zzcode.core.api.Connector#getContainer()
     */
    public Container getContainer() {
        return this.container;
    }

    private HttpRequest parseRequest(CharBuffer buffer) {
        HttpRequest request = new HttpRequest(servletContext);

        String requestStr = buffer.toString();
        ArrayList<String> requstLine = new ArrayList<String>(Arrays.asList(requestStr.split("\n")));
        String methodInfo = requstLine.remove(0);

        // 设置请求头
        Map<String, String> headerMap = handleHeader(requstLine);
        request.setHeaders(headerMap);

        // 设置方法
        String method = handleMethodType(methodInfo).trim();
        request.setMethod(method);

        // 设置http
        String protocol = parseProtocol(methodInfo);
        request.setProtocol(protocol);

        String requestURL = handleUrl(methodInfo).trim();

        // uri
        String parseRequestUrl = parseRequestUrl(requestURL);
        request.setRequestURI(parseRequestUrl);

        // 处理参数
        String parseQueryString = parseQueryString(requestURL);
        request.setQueryString(parseQueryString);

        // 处理参数map
        Map<String, String> parameters = pasrseParameters(parseQueryString);
        request.setParameters(parameters);

        return request;
    }

    /**
     * @param methodInfo
     */
    private String parseProtocol(String methodInfo) {
        int indexOf = methodInfo.indexOf("HTTP");
        return methodInfo.substring(indexOf, methodInfo.length());
    }

    /**
     * @param requestURL
     */
    private String parseRequestUrl(String requestURL) {
        int indexOf = requestURL.indexOf("?");
        if (indexOf > 0) {
            return requestURL.substring(0, indexOf);
        }
        return requestURL;
    }

    /**
     * @param parseQueryString
     */
    private Map<String, String> pasrseParameters(String parseQueryString) {
        Map<String, String> result = new HashMap<>();
        if (parseQueryString.length() > 0) {
            String[] split = parseQueryString.split("&");
            for (String parameter : split) {
                int indexOf = parameter.indexOf("=");
                String key = parameter.substring(0, indexOf);
                String value = parameter.substring(indexOf + 1, parameter.length());
                result.put(key, value);
            }
        }
        return result;

    }

    /**
     * 处理参数
     * 
     * @param requestURL
     */
    private String parseQueryString(String requestURL) {
        int indexOf = requestURL.indexOf("?");
        if (indexOf > 0) {
            return requestURL.substring(indexOf + 1);
        }
        return "";
    }

    /**
     * @param requstLine
     */
    private Map<String, String> handleHeader(List<String> requstLine) {

        Map<String, String> result = new HashMap<String, String>();
        for (String line : requstLine) {
            int indexOf = line.indexOf(":");
            if (indexOf != -1) {
                String key = line.substring(0, indexOf).trim();
                String value = line.substring(indexOf + 1).trim();
                result.put(key, value);
            }
        }
        return result;

    }

    /**
     * @param methodInfo
     */
    private String handleUrl(String methodInfo) {
        int firstIndex = methodInfo.indexOf("/");
        int lastIndexOf = methodInfo.lastIndexOf("HTTP");
        return methodInfo.substring(firstIndex, lastIndexOf);

    }

    /**
     * 
     */
    private String handleMethodType(String methodInfo) {
        int indexOf = methodInfo.indexOf("/");
        return methodInfo.substring(0, indexOf);
    }

    public static ServletContext getServletContex() {
        return servletContext;

    }
}

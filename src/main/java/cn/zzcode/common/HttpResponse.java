/*
 * $Id: HttpResponse.java, 2018年7月12日 下午4:18:37 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Title: HttpResponse
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月12日 下午4:18:37
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpResponse implements HttpServletResponse {

    private Map<String, String> headers = new HashMap<String, String>();

    private int status;

    private ByteBuffer buffer;

    private String contentType;

    /**
     * @see javax.servlet.ServletResponse#getCharacterEncoding()
     */
    public String getCharacterEncoding() {
        return null;
    }

    /**
     * @see javax.servlet.ServletResponse#getContentType()
     */
    public String getContentType() {
        return this.contentType;
    }

    /**
     * @see javax.servlet.ServletResponse#getOutputStream()
     */
    public ServletOutputStream getOutputStream() throws IOException {
        return new HttpServletOutputStream(buffer);
    }

    /**
     * @see javax.servlet.ServletResponse#getWriter()
     */
    public PrintWriter getWriter() throws IOException {
        return new HttpPrintWriter(new HttpServletOutputStream(buffer));
    }

    /**
     * @see javax.servlet.ServletResponse#setCharacterEncoding(java.lang.String)
     */
    public void setCharacterEncoding(String charset) {

    }

    /**
     * @see javax.servlet.ServletResponse#setContentLength(int)
     */
    public void setContentLength(int len) {

    }

    /**
     * @see javax.servlet.ServletResponse#setContentLengthLong(long)
     */
    public void setContentLengthLong(long len) {

    }

    /**
     * @see javax.servlet.ServletResponse#setContentType(java.lang.String)
     */
    public void setContentType(String type) {
        this.contentType = type;
    }

    /**
     * @see javax.servlet.ServletResponse#setBufferSize(int)
     */
    public void setBufferSize(int size) {

    }

    /**
     * @see javax.servlet.ServletResponse#getBufferSize()
     */
    public int getBufferSize() {
        return 0;
    }

    /**
     * @see javax.servlet.ServletResponse#flushBuffer()
     */
    public void flushBuffer() throws IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.ServletResponse#resetBuffer()
     */
    public void resetBuffer() {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.ServletResponse#isCommitted()
     */
    public boolean isCommitted() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @see javax.servlet.ServletResponse#reset()
     */
    public void reset() {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.ServletResponse#setLocale(java.util.Locale)
     */
    public void setLocale(Locale loc) {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.ServletResponse#getLocale()
     */
    public Locale getLocale() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addCookie(javax.servlet.http.Cookie)
     */
    public void addCookie(Cookie cookie) {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#containsHeader(java.lang.String)
     */
    public boolean containsHeader(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeURL(java.lang.String)
     */
    public String encodeURL(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectURL(java.lang.String)
     */
    public String encodeRedirectURL(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeUrl(java.lang.String)
     */
    public String encodeUrl(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectUrl(java.lang.String)
     */
    public String encodeRedirectUrl(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int,
     *      java.lang.String)
     */
    public void sendError(int sc, String msg) throws IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int)
     */
    public void sendError(int sc) throws IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendRedirect(java.lang.String)
     */
    public void sendRedirect(String location) throws IOException {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setDateHeader(java.lang.String,
     *      long)
     */
    public void setDateHeader(String name, long date) {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addDateHeader(java.lang.String,
     *      long)
     */
    public void addDateHeader(String name, long date) {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setHeader(java.lang.String,
     *      java.lang.String)
     */
    public void setHeader(String name, String value) {
        headers.put(name, value);

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addHeader(java.lang.String,
     *      java.lang.String)
     */
    public void addHeader(String name, String value) {
        headers.put(name, value);
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setIntHeader(java.lang.String,
     *      int)
     */
    public void setIntHeader(String name, int value) {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addIntHeader(java.lang.String,
     *      int)
     */
    public void addIntHeader(String name, int value) {
        // TODO Auto-generated method stub

    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setStatus(int)
     */
    public void setStatus(int sc) {
        this.status = sc;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setStatus(int,
     *      java.lang.String)
     */
    public void setStatus(int sc, String sm) {
        this.status = sc;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getStatus()
     */
    public int getStatus() {
        return this.status;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getHeader(java.lang.String)
     */
    public String getHeader(String name) {
        return headers.get(name);
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getHeaders(java.lang.String)
     */
    public Collection<String> getHeaders(String name) {
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getHeaderNames()
     */
    public Collection<String> getHeaderNames() {
        return headers.keySet();
    }

    /**
     * @param resource
     */
    public void addIncludedUrl(String resource) {
        // TODO Auto-generated method stub

    }

    /**
     * @param resource
     */
    public void setForwardedUrl(String resource) {

    }

    /**
     * @param buffer
     *            the buffer to set
     */
    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    /**
     * @return the buffer
     */
    public ByteBuffer getBuffer() {
        return buffer;
    }

    /**
     * @return the contextType
     */
    public String getContextType() {
        return contentType;
    }
}

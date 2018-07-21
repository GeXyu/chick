/*
 * $Id: HttpServletInputStream.java, 2018年7月20日 下午7:41:31 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;

/**
 * <p>
 * Title: HttpServletInputStream
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月20日 下午7:41:31
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpServletInputStream extends ServletInputStream {

    private ByteArrayInputStream byteStream;

    public HttpServletInputStream(ByteBuffer byteBuffer) {
        byteStream = new ByteArrayInputStream(byteBuffer.array());
    }

    /**
     * @see javax.servlet.ServletInputStream#isFinished()
     */
    @Override
    public boolean isFinished() {

        return false;

    }

    /**
     * @see javax.servlet.ServletInputStream#isReady()
     */
    @Override
    public boolean isReady() {

        return false;
    }

    /**
     * @see javax.servlet.ServletInputStream#setReadListener(javax.servlet.ReadListener)
     */
    @Override
    public void setReadListener(ReadListener readListener) {

    }

    /**
     * @see java.io.InputStream#read()
     */
    @Override
    public int read() throws IOException {

        return byteStream.read();
    }

}

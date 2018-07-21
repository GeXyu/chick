/*
 * $Id: HttpServletOutputStream.java, 2018年7月21日 下午10:46:16 XiuYu.Ge Exp $
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
import java.nio.ByteBuffer;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

/**
 * <p>
 * Title: HttpServletOutputStream
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月21日 下午10:46:16
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpServletOutputStream extends ServletOutputStream {

    ByteBuffer buffer;

    /**
     * @see javax.servlet.ServletOutputStream#isReady()
     */
    @Override
    public boolean isReady() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @see javax.servlet.ServletOutputStream#setWriteListener(javax.servlet.WriteListener)
     */
    @Override
    public void setWriteListener(WriteListener writeListener) {
        // TODO Auto-generated method stub

    }

    /**
     * @see java.io.OutputStream#write(int)
     */
    @Override
    public void write(int b) throws IOException {
        buffer.put((byte) b);

    }

}

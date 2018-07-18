/*
 * $Id: HttpResponse.java, 2018年7月18日 下午1:27:09 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzocde.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

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
 * @created 2018年7月18日 下午1:27:09
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpResponse implements HttpServletResponse {

    /**
     * @see javax.servlet.ServletResponse#getCharacterEncoding()
     */
    @Override
    public String getCharacterEncoding() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.ServletResponse#getContentType()
     */
    @Override
    public String getContentType() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.ServletResponse#getOutputStream()
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.ServletResponse#getWriter()
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.ServletResponse#setCharacterEncoding(java.lang.String)
     */
    @Override
    public void setCharacterEncoding(String charset) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#setContentLength(int)
     */
    @Override
    public void setContentLength(int len) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#setContentLengthLong(long)
     */
    @Override
    public void setContentLengthLong(long len) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#setContentType(java.lang.String)
     */
    @Override
    public void setContentType(String type) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#setBufferSize(int)
     */
    @Override
    public void setBufferSize(int size) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#getBufferSize()
     */
    @Override
    public int getBufferSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @see javax.servlet.ServletResponse#flushBuffer()
     */
    @Override
    public void flushBuffer() throws IOException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#resetBuffer()
     */
    @Override
    public void resetBuffer() {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#isCommitted()
     */
    @Override
    public boolean isCommitted() {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @see javax.servlet.ServletResponse#reset()
     */
    @Override
    public void reset() {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#setLocale(java.util.Locale)
     */
    @Override
    public void setLocale(Locale loc) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.ServletResponse#getLocale()
     */
    @Override
    public Locale getLocale() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addCookie(javax.servlet.http.Cookie)
     */
    @Override
    public void addCookie(Cookie cookie) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#containsHeader(java.lang.String)
     */
    @Override
    public boolean containsHeader(String name) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeURL(java.lang.String)
     */
    @Override
    public String encodeURL(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectURL(java.lang.String)
     */
    @Override
    public String encodeRedirectURL(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeUrl(java.lang.String)
     */
    @Override
    public String encodeUrl(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#encodeRedirectUrl(java.lang.String)
     */
    @Override
    public String encodeRedirectUrl(String url) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int, java.lang.String)
     */
    @Override
    public void sendError(int sc, String msg) throws IOException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendError(int)
     */
    @Override
    public void sendError(int sc) throws IOException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#sendRedirect(java.lang.String)
     */
    @Override
    public void sendRedirect(String location) throws IOException {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setDateHeader(java.lang.String, long)
     */
    @Override
    public void setDateHeader(String name, long date) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addDateHeader(java.lang.String, long)
     */
    @Override
    public void addDateHeader(String name, long date) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setHeader(java.lang.String, java.lang.String)
     */
    @Override
    public void setHeader(String name, String value) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addHeader(java.lang.String, java.lang.String)
     */
    @Override
    public void addHeader(String name, String value) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setIntHeader(java.lang.String, int)
     */
    @Override
    public void setIntHeader(String name, int value) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#addIntHeader(java.lang.String, int)
     */
    @Override
    public void addIntHeader(String name, int value) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setStatus(int)
     */
    @Override
    public void setStatus(int sc) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#setStatus(int, java.lang.String)
     */
    @Override
    public void setStatus(int sc, String sm) {
        // TODO Auto-generated method stub
        
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getStatus()
     */
    @Override
    public int getStatus() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getHeader(java.lang.String)
     */
    @Override
    public String getHeader(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getHeaders(java.lang.String)
     */
    @Override
    public Collection<String> getHeaders(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.http.HttpServletResponse#getHeaderNames()
     */
    @Override
    public Collection<String> getHeaderNames() {
        // TODO Auto-generated method stub
        return null;
    }

}

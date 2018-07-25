/*
 * $Id: HttpServletConfig.java, 2018年7月17日 下午1:41:58 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.util.Assert;

/**
 * <p>
 * Title: HttpServletConfig
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月17日 下午1:41:58
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpServletConfig implements ServletConfig {
    private final ServletContext servletContext;

    private final String servletName;

    private final Map<String, String> initParameters = new LinkedHashMap<String, String>();

    /**
     * Create a new MockServletConfig with a default {@link MockServletContext}.
     */
    public HttpServletConfig() {
        this(null, "");
    }

    /**
     * Create a new MockServletConfig with a default {@link MockServletContext}.
     * 
     * @param servletName
     *            the name of the servlet
     */
    public HttpServletConfig(String servletName) {
        this(null, servletName);
    }

    /**
     * Create a new MockServletConfig.
     * 
     * @param servletContext
     *            the ServletContext that the servlet runs in
     */
    public HttpServletConfig(ServletContext servletContext) {
        this(servletContext, "");
    }

    /**
     * Create a new MockServletConfig.
     * 
     * @param servletContext
     *            the ServletContext that the servlet runs in
     * @param servletName
     *            the name of the servlet
     */
    public HttpServletConfig(ServletContext servletContext, String servletName) {
        this.servletContext = servletContext;
        this.servletName = servletName;
    }

    @Override
    public String getServletName() {
        return this.servletName;
    }

    @Override
    public ServletContext getServletContext() {
        return this.servletContext;
    }

    public void addInitParameter(String name, String value) {
        Assert.notNull(name, "Parameter name must not be null");
        this.initParameters.put(name, value);
    }

    @Override
    public String getInitParameter(String name) {
        Assert.notNull(name, "Parameter name must not be null");
        return this.initParameters.get(name);
    }

    @Override
    public Enumeration<String> getInitParameterNames() {
        return Collections.enumeration(this.initParameters.keySet());
    }

}

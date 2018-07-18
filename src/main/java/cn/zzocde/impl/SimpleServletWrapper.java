/*
 * $Id: SimpleServletWrapper.java, 2018年7月18日 下午1:32:21 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzocde.impl;

import javax.servlet.Servlet;

import cn.zzocde.api.Container;
import cn.zzocde.api.Wrapper;
import cn.zzocde.common.HttpRequest;
import cn.zzocde.common.HttpResponse;

/**
 * <p>
 * Title: SimpleServletWrapper
 * </p>
 * <p>
 * Description:类
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月18日 下午1:32:21
 * @modified [who date description]
 * @check [who date description]
 */
public class SimpleServletWrapper implements Wrapper {

    private Container parent;

    private String name;

    private Servlet servlet;

    private String servletClass;

    /**
     * @see cn.zzocde.api.Container#setParent(cn.zzocde.api.Container)
     */
    @Override
    public void setParent(Container container) {
        this.parent = container;

    }

    /**
     * @see cn.zzocde.api.Container#getParent()
     */
    @Override
    public Container getParent() {
        return parent;
    }

    /**
     * @see cn.zzocde.api.Container#addChild(cn.zzocde.api.Container)
     */
    @Override
    public void addChild(Container child) {

    }

    /**
     * @see cn.zzocde.api.Container#getChild(java.lang.String)
     */
    @Override
    public Container getChild(String name) {
        return null;
    }

    /**
     * @see cn.zzocde.api.Container#setName(java.lang.String)
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @see cn.zzocde.api.Container#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @see cn.zzocde.api.Container#invoke(cn.zzocde.common.HttpRequest,
     *      cn.zzocde.common.HttpResponse)
     */
    @Override
    public void invoke(HttpRequest request, HttpResponse response) {

    }

    /**
     * @see cn.zzocde.api.Wrapper#getServletClass()
     */
    @Override
    public String getServletClass() {
        return servletClass;
    }

    /**
     * @see cn.zzocde.api.Wrapper#setServletClass(java.lang.String)
     */
    @Override
    public void setServletClass(String className) {
        this.servletClass = className;
    }

    /**
     * @see cn.zzocde.api.Wrapper#getServlet()
     */
    @Override
    public Servlet getServlet() {
        return this.servlet;
    }

    /**
     * @see cn.zzocde.api.Wrapper#setServlet(javax.servlet.Servlet)
     */
    @Override
    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

}

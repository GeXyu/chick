/*
 * $Id: SimpleWrapper.java, 2018年7月12日 下午10:09:59 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import javax.servlet.Servlet;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;
import cn.zzcode.core.api.Container;
import cn.zzcode.core.api.Loader;
import cn.zzcode.core.api.Pipeline;
import cn.zzcode.core.api.Value;
import cn.zzcode.core.api.Wrapper;

/**
 * <p>
 * Title: SimpleWrapper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月12日 下午10:09:59
 * @modified [who date description]
 * @check [who date description]
 */
public class SimpleWrapper implements Wrapper, Pipeline {

    private String name;
    private Container parent;
    private Pipeline pipeline = new SimplePipeline();
    private Loader loader;
    private Servlet servlet;
    private String className;

    public SimpleWrapper() {
        pipeline.setBasic(new BasicContextValue(this));

    }

    /**
     * @see cn.zzcode.core.api.Container#invoke(cn.zzcode.common.HttpRequest,
     *      cn.zzcode.common.HttpResponse)
     */
    public void invoke(HttpRequest request, HttpResponse response) {
        pipeline.invoke(request, response);
    }

    /**
     * @see cn.zzcode.core.api.Container#setParent(cn.zzcode.core.api.Container)
     */
    public void setParent(Container container) {
        this.parent = container;
    }

    /**
     * @see cn.zzcode.core.api.Container#getParent(cn.zzcode.core.api.Container)
     */
    public Container getParent() {
        return this.parent;
    }

    /**
     * @see cn.zzcode.core.api.Container#findChild(java.lang.String)
     */
    public Container findChild(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see cn.zzcode.core.api.Container#addChild(cn.zzcode.core.api.Container)
     */
    public void addChild(Container container) {
        // TODO Auto-generated method stub

    }

    /**
     * @see cn.zzcode.core.api.Container#setName(java.lang.String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @see cn.zzcode.core.api.Container#getName()
     */
    public String getName() {
        return this.name;
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#addValue(cn.zzcode.core.api.Value)
     */
    public void addValue(Value value) {
        pipeline.addValue(value);
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#removeValue(cn.zzcode.core.api.Value)
     */
    public void removeValue(Value value) {
        pipeline.removeValue(value);
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#setBasic(cn.zzcode.core.api.Value)
     */
    public void setBasic(Value value) {
        pipeline.setBasic(value);
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#getBasic(cn.zzcode.core.api.Value)
     */
    public Value getBasic() {
        return null;
    }

    /**
     * 
     */
    public Servlet loadServlet() {
        if (servlet != null) {
            return servlet;
        }

        ClassLoader classLoader = getLoader().getClassLoader();
        Class<?> loadClass;
        try {
            loadClass = classLoader.loadClass(className);

            servlet = (Servlet) loadClass.newInstance();
            return servlet;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @see cn.zzcode.core.api.Wrapper#getLoader()
     */
    public Loader getLoader() {
        return this.loader;
    }

    /**
     * @see cn.zzcode.core.api.Wrapper#setLoader(cn.zzcode.core.api.Loader)
     */
    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    /**
     * @see cn.zzcode.core.api.Wrapper#getClassName()
     */
    public String getClassName() {
        return this.className;
    }

    /**
     * @see cn.zzcode.core.api.Wrapper#setClassName(java.lang.String)
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * @return the servlet
     */
    public Servlet getServlet() {
        return servlet;
    }

    /**
     * @param servlet
     *            the servlet to set
     */
    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }

}

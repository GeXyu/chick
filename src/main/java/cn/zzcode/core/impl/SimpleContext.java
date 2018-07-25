/*
 * $Id: HttpContainer.java, 2018年7月12日 下午7:11:39 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;

import cn.zzcode.common.FilterDef;
import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;
import cn.zzcode.core.api.Container;
import cn.zzcode.core.api.Context;
import cn.zzcode.core.api.Mapper;
import cn.zzcode.core.api.Pipeline;
import cn.zzcode.core.api.Value;
import cn.zzcode.core.api.Wrapper;

/**
 * <p>
 * Title: HttpContainer
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月12日 下午7:11:39
 * @modified [who date description]
 * @check [who date description]
 */
public class SimpleContext implements Context, Pipeline {

    private Pipeline pipeline = new SimplePipeline();
    private Map<String, Container> childs = new HashMap<String, Container>();
    private Map<String, String> servletMappers = new HashMap<String, String>();
    private List<FilterDef> filterDefs = new ArrayList<FilterDef>();
    private ServletContext servletContext;
    private Mapper mapper;
    private String name;

    public SimpleContext() {
        setBasic(new BasicContextValue(this));
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

    }

    /**
     * @see cn.zzcode.core.api.Container#getParent(cn.zzcode.core.api.Container)
     */
    public Container getParent() {
        return null;
    }

    /**
     * @see cn.zzcode.core.api.Container#findChild(java.lang.String)
     */
    public Container findChild(String name) {
        return childs.get(name);
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
     * @see cn.zzcode.core.api.Container#addChild(cn.zzcode.core.api.Container)
     */
    public void addChild(Container container) {
        childs.put(container.getName(), container);
        container.setParent(this);
    }

    /**
     * @see cn.zzcode.core.api.Context#addServletMapper(java.lang.String,
     *      java.lang.String)
     */
    public void addServletMapper(String mapper, String servletName) {
        servletMappers.put(mapper, servletName);
    }

    /**
     * @see cn.zzcode.core.api.Context#getServletMapper(java.lang.String)
     */
    public String getServletMapper(String mapper) {
        return servletMappers.get(mapper);
    }

    /**
     * @see cn.zzcode.core.api.Context#setMapper(cn.zzcode.core.api.Mapper)
     */
    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    /**
     * @see cn.zzcode.core.api.Context#getMapper()
     */
    public Mapper getMapper() {
        return this.mapper;

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
     * @see cn.zzcode.core.api.Pipeline#getBasic()
     */
    public Value getBasic() {
        return pipeline.getBasic();
    }

    /**
     * @see cn.zzcode.core.api.Context#addFilterDef(cn.zzcode.common.FilterDef)
     */
    @Override
    public void addFilterDef(FilterDef filterDef) {
        filterDefs.add(filterDef);
    }

    /**
     * @see cn.zzcode.core.api.Context#getFilterDefs()
     */
    @Override
    public List<FilterDef> getFilterDefs() {
        return filterDefs;
    }

    /**
     * @see cn.zzcode.core.api.Context#getFilterByURI(java.lang.String)
     */
    @Override
    public List<FilterDef> getFilterByURI(String uri) {

        Set<FilterDef> result = new HashSet<>();
        for (FilterDef filterdef : filterDefs) {
            Set<String> urls = filterdef.getUrls();
            for (String url : urls) {
                String reg = uri.replace("/", ".");
                if (Pattern.matches(reg, url)) {
                    result.add(filterdef);
                }
            }
        }

        return new ArrayList<>(result);
    }

    /**
     * @see cn.zzcode.core.api.Context#createWrapper()
     */
    @Override
    public Wrapper createWrapper() {
        Wrapper simpleWrapper = new SimpleWrapper();
        simpleWrapper.setParent(this);
        simpleWrapper.setLoader(new SimpleLoader());
        return simpleWrapper;
    }

    /**
     * @see cn.zzcode.core.api.Context#getServletContext()
     */
    @Override
    public ServletContext getServletContext() {
        return this.servletContext;
    }

    /**
     * @param servletContext
     *            the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

}

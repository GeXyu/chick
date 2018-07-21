/*
 * $Id: HttpFilterRegistration.java, 2018年7月19日 上午6:32:36 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;

/**
 * <p>
 * Title: HttpFilterRegistration
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月19日 上午6:32:36
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpFilterRegistration implements FilterRegistration {

    private ServletContext servletContext;

    private String name;

    private FilterDef filterDef = null;

    private Set<String> mappingForServletNames = new HashSet<>();

    private Set<String> mappingForUrlPatterns = new HashSet<>();

    /**
     * @param httpServletContext
     */
    public HttpFilterRegistration(HttpServletContext httpServletContext, FilterDef filterDef) {
        this.servletContext = httpServletContext;
        this.filterDef = filterDef;
    }

    /**
     * @see javax.servlet.Registration#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * @see javax.servlet.Registration#getClassName()
     */
    @Override
    public String getClassName() {
        return name;
    }

    /**
     * @see javax.servlet.Registration#setInitParameter(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public boolean setInitParameter(String name, String value) {
        // TODO Auto-generated method stub
        return false;
    }

    /**
     * @see javax.servlet.Registration#getInitParameter(java.lang.String)
     */
    @Override
    public String getInitParameter(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.Registration#setInitParameters(java.util.Map)
     */
    @Override
    public Set<String> setInitParameters(Map<String, String> initParameters) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.Registration#getInitParameters()
     */
    @Override
    public Map<String, String> getInitParameters() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @see javax.servlet.FilterRegistration#addMappingForServletNames(java.util.EnumSet,
     *      boolean, java.lang.String[])
     */
    @Override
    public void addMappingForServletNames(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter,
            String... servletNames) {
        for (String servletName : servletNames) {
            mappingForServletNames.add(servletName);
            filterDef.addServlet(servletName);
        }
    }

    /**
     * @see javax.servlet.FilterRegistration#getServletNameMappings()
     */
    @Override
    public Collection<String> getServletNameMappings() {
        return mappingForServletNames;
    }

    /**
     * @see javax.servlet.FilterRegistration#addMappingForUrlPatterns(java.util.EnumSet,
     *      boolean, java.lang.String[])
     */
    @Override
    public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter,
            String... urlPatterns) {
        for (String url : urlPatterns) {
            mappingForUrlPatterns.add(url);
            filterDef.addUrl(url);
        }
    }

    /**
     * @see javax.servlet.FilterRegistration#getUrlPatternMappings()
     */
    @Override
    public Collection<String> getUrlPatternMappings() {
        return mappingForUrlPatterns;
    }

    /**
     * @return the servletContext
     */
    public ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * @param servletContext
     *            the servletContext to set
     */
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the filterDef
     */
    public FilterDef getFilterDef() {
        return filterDef;
    }

    /**
     * @param filterDef
     *            the filterDef to set
     */
    public void setFilterDef(FilterDef filterDef) {
        this.filterDef = filterDef;
    }

}

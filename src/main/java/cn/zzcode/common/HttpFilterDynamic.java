/*
 * $Id: HttpFilterDynamic.java, 2018年7月19日 上午6:30:26 XiuYu.Ge Exp $
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
import java.util.Map;
import java.util.Set;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.FilterRegistration.Dynamic;

/**
 * <p>
 * Title: HttpFilterDynamic
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月19日 上午6:30:26
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpFilterDynamic implements Dynamic {

    private FilterRegistration filterRegistration;

    /**
     * @param httpFilterRegistration
     */
    public HttpFilterDynamic(HttpFilterRegistration httpFilterRegistration) {
        this.filterRegistration = httpFilterRegistration;
    }

    /**
     * @see javax.servlet.FilterRegistration#addMappingForServletNames(java.util.EnumSet,
     *      boolean, java.lang.String[])
     */
    @Override
    public void addMappingForServletNames(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter,
            String... servletNames) {
        filterRegistration.addMappingForServletNames(dispatcherTypes, isMatchAfter, servletNames);
    }

    /**
     * @see javax.servlet.FilterRegistration#getServletNameMappings()
     */
    @Override
    public Collection<String> getServletNameMappings() {
        System.out.println("serlvet name mappings");
        return filterRegistration.getServletNameMappings();
    }

    /**
     * @see javax.servlet.FilterRegistration#addMappingForUrlPatterns(java.util.EnumSet,
     *      boolean, java.lang.String[])
     */
    @Override
    public void addMappingForUrlPatterns(EnumSet<DispatcherType> dispatcherTypes, boolean isMatchAfter,
            String... urlPatterns) {
        filterRegistration.addMappingForUrlPatterns(dispatcherTypes, isMatchAfter, urlPatterns);
    }

    /**
     * @see javax.servlet.FilterRegistration#getUrlPatternMappings()
     */
    @Override
    public Collection<String> getUrlPatternMappings() {
        System.out.println("serlvet url patter");
        return filterRegistration.getUrlPatternMappings();
    }

    /**
     * @see javax.servlet.Registration#getName()
     */
    @Override
    public String getName() {
        return filterRegistration.getName();
    }

    /**
     * @see javax.servlet.Registration#getClassName()
     */
    @Override
    public String getClassName() {
        // TODO Auto-generated method stub
        return filterRegistration.getClassName();
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
     * @see javax.servlet.Registration.Dynamic#setAsyncSupported(boolean)
     */
    @Override
    public void setAsyncSupported(boolean isAsyncSupported) {
        // TODO Auto-generated method stub

    }

}

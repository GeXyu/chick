/*
 * $Id: Dynamic.java, 2018年7月17日 下午12:58:33 XiuYu.Ge Exp $
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
import java.util.Map;
import java.util.Set;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletSecurityElement;

/**
 * <p>
 * Title: Dynamic
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月17日 下午12:58:33
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpDynamic implements ServletRegistration.Dynamic {

    private HttpServletRegistration myServletRegistration;

    private MultipartConfigElement multipartConfigElement;

    private boolean asyncSupported;

    public HttpDynamic(HttpServletRegistration myServletRegistration) {
        this.myServletRegistration = myServletRegistration;
    }

    public void setLoadOnStartup(int i) {
        myServletRegistration.setLoadOnStartup(i);
    }

    public void setMultipartConfig(MultipartConfigElement multipartConfigElement) {
        this.multipartConfigElement = multipartConfigElement;
    }

    public void setRunAsRole(String s) {
        myServletRegistration.setRunAsRole(s);
    }

    public Set<String> setServletSecurity(ServletSecurityElement servletSecurityElement) {
        return null;
    }

    public void setAsyncSupported(boolean b) {
        this.asyncSupported = b;
    }

    public Set<String> addMapping(String... strings) {
        return myServletRegistration.addMapping(strings);
    }

    public Collection<String> getMappings() {
        return myServletRegistration.getMappings();
    }

    public String getRunAsRole() {
        return myServletRegistration.getRunAsRole();
    }

    public String getName() {
        return myServletRegistration.getName();
    }

    public String getClassName() {
        return this.getName();
    }

    public boolean setInitParameter(String s, String s1) {
        myServletRegistration.setInitParameter(s, s1);
        return true;
    }

    public String getInitParameter(String s) {
        return myServletRegistration.getInitParameter(s);
    }

    public Set<String> setInitParameters(Map<String, String> map) {
        return myServletRegistration.setInitParameters(map);
    }

    public Map<String, String> getInitParameters() {
        return myServletRegistration.getInitParameters();
    }

    /**
     * @return the myServletRegistration
     */
    public HttpServletRegistration getMyServletRegistration() {
        return myServletRegistration;
    }

    /**
     * @param myServletRegistration
     *            the myServletRegistration to set
     */
    public void setMyServletRegistration(HttpServletRegistration myServletRegistration) {
        this.myServletRegistration = myServletRegistration;
    }

    /**
     * @return the multipartConfigElement
     */
    public MultipartConfigElement getMultipartConfigElement() {
        return multipartConfigElement;
    }

    /**
     * @param multipartConfigElement
     *            the multipartConfigElement to set
     */
    public void setMultipartConfigElement(MultipartConfigElement multipartConfigElement) {
        this.multipartConfigElement = multipartConfigElement;
    }

    /**
     * @return the asyncSupported
     */
    public boolean isAsyncSupported() {
        return asyncSupported;
    }

}

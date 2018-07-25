/*
 * $Id: FilterDef.java, 2018年7月21日 上午11:19:32 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * Title: FilterDef
 * </p>
 * <p>
 * Description:过滤器定义
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月21日 上午11:19:32
 * @modified [who date description]
 * @check [who date description]
 */
public class FilterDef {

    private String name;

    private String desplayName;

    private String filterClass;

    private Set<String> urls = new HashSet<>();

    private Set<String> servlets = new HashSet<>();

    private Map<String, Object> parameters = new HashMap<String, Object>();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the desplayName
     */
    public String getDesplayName() {
        return desplayName;
    }

    /**
     * @param desplayName
     *            the desplayName to set
     */
    public void setDesplayName(String desplayName) {
        this.desplayName = desplayName;
    }

    /**
     * @return the filterClass
     */
    public String getFilterClass() {
        return filterClass;
    }

    /**
     * @param filterClass
     *            the filterClass to set
     */
    public void setFilterClass(String filterClass) {
        this.filterClass = filterClass;
    }

    /**
     * @return the parameters
     */
    public Map<String, Object> getParameters() {
        return parameters;
    }

    /**
     * @param parameters
     *            the parameters to set
     */
    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }

    /**
     * 
     */
    public FilterDef() {
        super();
    }

    /**
     * @param filterName
     * @param valueOf
     */
    public FilterDef(String filterName, String filterClass) {
        this.name = filterName;
        this.filterClass = filterClass;
    }

    public void addUrl(String url) {
        this.urls.add(url);
    }

    public void addServlet(String servlet) {
        this.servlets.add(servlet);
    }

    /**
     * @return the urls
     */
    public Set<String> getUrls() {
        return urls;
    }
}

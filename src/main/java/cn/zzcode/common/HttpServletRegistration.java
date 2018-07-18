/*
 * $Id: HttpServletRegistration.java, 2018年7月17日 下午12:48:28 XiuYu.Ge Exp $
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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletRegistration;

/**
 * <p>
 * Title: HttpServletRegistration
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月17日 下午12:48:28
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpServletRegistration implements ServletRegistration {

    private HttpServletContext httpServletContext;

    private String runAsRole;

    private Set<String> mapping = new HashSet<String>();

    private int loadOnStart;

    public HttpServletRegistration(HttpServletContext myMockServletContext) {
        this.httpServletContext = myMockServletContext;
    }

    public Set<String> addMapping(String... strings) {
        for (String string : strings) {
            mapping.add(string);
        }
        return mapping;
    }

    public Collection<String> getMappings() {
        return mapping;
    }

    public String getRunAsRole() {
        return runAsRole;
    }

    public String getName() {
        return httpServletContext.getServletContextName();
    }

    public String getClassName() {
        return this.getName();
    }

    public boolean setInitParameter(String s, String s1) {
        return httpServletContext.setInitParameter(s, s1);
    }

    public String getInitParameter(String s) {
        return httpServletContext.getInitParameter(s);
    }

    public Set<String> setInitParameters(Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpServletContext.setInitParameter(entry.getKey(), entry.getValue());
        }
        return map.keySet();
    }

    public Map<String, String> getInitParameters() {
        Map<String, String> map = new HashMap<String, String>();
        Enumeration<String> names = httpServletContext.getInitParameterNames();
        while (names.hasMoreElements()) {
            String key = names.nextElement();
            map.put(key, httpServletContext.getInitParameter(key));
        }
        return map;
    }

    public void setLoadOnStartup(int i) {
        this.loadOnStart = i;
    }

    public void setRunAsRole(String s) {
        this.setRunAsRole(s);
    }

    /**
     * @return the loadOnStart
     */
    public int getLoadOnStart() {
        return loadOnStart;
    }

    /**
     * @param loadOnStart
     *            the loadOnStart to set
     */
    public void setLoadOnStart(int loadOnStart) {
        this.loadOnStart = loadOnStart;
    }

}

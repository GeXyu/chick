/*
 * $Id: HttpFilterChain.java, 2018年7月21日 上午11:23:57 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * <p>
 * Title: HttpFilterChain
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月21日 上午11:23:57
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpFilterChain implements FilterChain {

    private FilterChain filterChain;

    private Servlet servlet;

    private int cursor = 0;

    private List<Filter> filters;

    /**
     * @return the filters
     */
    public List<Filter> getFilters() {
        return filters;
    }

    /**
     * @param filters
     *            the filters to set
     */
    public void setFilters(List<Filter> filters) {
        this.filters = filters;
    }

    /**
     * @return the filterChain
     */
    public FilterChain getFilterChain() {
        return filterChain;
    }

    /**
     * @return the servlet
     */
    public Servlet getServlet() {
        return servlet;
    }

    /**
     * @see javax.servlet.FilterChain#doFilter(javax.servlet.ServletRequest,
     *      javax.servlet.ServletResponse)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        int sub = cursor;
        cursor++;
        if (sub < filters.size()) {
            filterChain.doFilter(request, response);
        } else {
            servlet.service(request, response);
        }
    }

    /**
     * @param filterChain
     *            the filterChain to set
     */
    public void setFilterChain(FilterChain filterChain) {
        this.filterChain = filterChain;
    }

    /**
     * @param servlet
     *            the servlet to set
     */
    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}

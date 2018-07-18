/*
 * $Id: HttpRequestDispatcher.java, 2018年7月17日 下午2:17:04 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * <p>
 * Title: HttpRequestDispatcher
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月17日 下午2:17:04
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpRequestDispatcher implements RequestDispatcher {
    // private final Log logger = LogFactory.getLog(getClass());

    private final String resource;

    /**
     * Create a new MockRequestDispatcher for the given resource.
     * 
     * @param resource
     *            the server resource to dispatch to, located at a particular
     *            path or given by a particular name
     */
    public HttpRequestDispatcher(String resource) {
        // Assert.notNull(resource, "Resource must not be null");
        this.resource = resource;
    }

    @Override
    public void forward(ServletRequest request, ServletResponse response) {
        // Assert.notNull(request, "Request must not be null");
        // Assert.notNull(response, "Response must not be null");
        // Assert.state(!response.isCommitted(), "Cannot perform forward -
        // response is already committed");
        getMockHttpServletResponse(response).setForwardedUrl(this.resource);
        // if (logger.isDebugEnabled()) {
        // logger.debug("MockRequestDispatcher: forwarding to [" + this.resource
        // + "]");
        // }
    }

    @Override
    public void include(ServletRequest request, ServletResponse response) {
        // Assert.notNull(request, "Request must not be null");
        // Assert.notNull(response, "Response must not be null");
        getMockHttpServletResponse(response).addIncludedUrl(this.resource);
        // if (logger.isDebugEnabled()) {
        // logger.debug("MockRequestDispatcher: including [" + this.resource +
        // "]");
        // }
    }

    /**
     * Obtain the underlying {@link MockHttpServletResponse}, unwrapping
     * {@link HttpServletResponseWrapper} decorators if necessary.
     */
    protected HttpResponse getMockHttpServletResponse(ServletResponse response) {
        if (response instanceof HttpResponse) {
            return (HttpResponse) response;
        }
        if (response instanceof HttpServletResponseWrapper) {
            return getMockHttpServletResponse(((HttpServletResponseWrapper) response).getResponse());
        }
        throw new IllegalArgumentException("MockRequestDispatcher requires MockHttpServletResponse");
    }

}

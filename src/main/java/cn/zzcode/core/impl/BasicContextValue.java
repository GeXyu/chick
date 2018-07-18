/*
 * $Id: BasicContextValue.java, 2018年7月12日 下午9:56:20 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;
import cn.zzcode.core.api.Container;
import cn.zzcode.core.api.Context;
import cn.zzcode.core.api.Value;
import cn.zzcode.core.api.ValueContext;
import cn.zzcode.core.api.Wrapper;

/**
 * <p>
 * Title: BasicContextValue
 * </p>
 * <p>
 * Description:基础阀
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月12日 下午9:56:20
 * @modified [who date description]
 * @check [who date description]
 */
public class BasicContextValue implements Value {

    private Container container;

    /**
     * @param simpleWrapper
     */
    public BasicContextValue(Container simpleWrapper) {
        this.container = simpleWrapper;
    }

    /**
     * @see cn.zzcode.core.api.Value#invoke(cn.zzcode.common.HttpRequest,
     *      cn.zzcode.common.HttpResponse, cn.zzcode.core.api.ValueContext)
     */
    public void invoke(HttpRequest request, HttpResponse response, ValueContext valueContext) {
        Context warpper = (Context) container;
        Wrapper simpleWarrper = (Wrapper) warpper.getMapper().map(request, false);

        Servlet loadServlet = simpleWarrper.loadServlet();
        try {
            loadServlet.service(request, response);

        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
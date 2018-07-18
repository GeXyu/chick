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
import cn.zzcode.core.api.Value;
import cn.zzcode.core.api.ValueContext;

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
public class BasicWappertValue implements Value {

    private Container container;

    /**
     * @param simpleWrapper
     */
    public BasicWappertValue(Container simpleWrapper) {
        this.container = simpleWrapper;
    }

    /**
     * @see cn.zzcode.core.api.Value#invoke(cn.zzcode.common.HttpRequest,
     *      cn.zzcode.common.HttpResponse, cn.zzcode.core.api.ValueContext)
     */
    public void invoke(HttpRequest request, HttpResponse response, ValueContext valueContext) {
        SimpleWrapper warpper = (SimpleWrapper) container;
        Servlet servlet = warpper.loadServlet();
        try {
            servlet.service(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

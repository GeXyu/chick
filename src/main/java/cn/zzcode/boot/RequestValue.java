/*
 * $Id: RequestValue.java, 2018年7月17日 下午6:40:20 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.boot;

import java.io.IOException;

import javax.servlet.ServletException;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;
import cn.zzcode.core.api.Value;
import cn.zzcode.core.api.ValueContext;

/**
 * <p>
 * Title: RequestValue
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月17日 下午6:40:20
 * @modified [who date description]
 * @check [who date description]
 */
public class RequestValue implements Value {

    /**
     * @throws ServletException
     * @throws IOException
     * @see cn.zzcode.core.api.Value#invoke(cn.zzcode.common.HttpRequest,
     *      cn.zzcode.common.HttpResponse, cn.zzcode.core.api.ValueContext)
     */
    @Override
    public void invoke(HttpRequest request, HttpResponse response, ValueContext valueContext) throws IOException, ServletException {
        // request.setAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE,
        // "/HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE");
        valueContext.invokeNext(request, response);
    }

}

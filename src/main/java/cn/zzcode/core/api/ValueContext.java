/*
 * $Id: ValueContext.java, 2018年7月10日 下午7:09:19 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.api;

import java.io.IOException;

import javax.servlet.ServletException;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;

/**
 * <p>
 * Title: ValueContext
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:09:19
 * @modified [who date description]
 * @check [who date description]
 */
public interface ValueContext {

    void invokeNext(HttpRequest request, HttpResponse response) throws IOException, ServletException;
}

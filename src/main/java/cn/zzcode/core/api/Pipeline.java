/*
 * $Id: Pipeline.java, 2018年7月10日 下午7:04:31 XiuYu.Ge Exp $
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
 * Title: Pipeline
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:04:31
 * @modified [who date description]
 * @check [who date description]
 */
public interface Pipeline {

    void invoke(HttpRequest request, HttpResponse response) throws IOException, ServletException;

    /**
     * 添加
     * 
     * @param value
     * @return
     */
    void addValue(Value value);

    /**
     * 删除
     * 
     * @param value
     */
    void removeValue(Value value);

    /**
     * 设置基础阀
     * 
     * @param value
     */
    void setBasic(Value value);

    /**
     * 获取基础阀
     * 
     * @param value
     * @return
     */
    Value getBasic();
}

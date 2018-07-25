/*
 * $Id: Container.java, 2018年7月10日 下午7:09:55 XiuYu.Ge Exp $
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
 * Title: Container
 * </p>
 * <p>
 * Description:容器顶级抽象
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:09:55
 * @modified [who date description]
 * @check [who date description]
 */
public interface Container {

    void invoke(HttpRequest request, HttpResponse response) throws IOException, ServletException;

    /**
     * 设置父容器
     * 
     * @param container
     */
    void setParent(Container container);

    /**
     * 得到夫容器
     * 
     * @param container
     */
    Container getParent();

    /**
     * 获取子
     * 
     * @param name
     * @return
     */
    Container findChild(String name);

    /**
     * 添加子容器
     * 
     * @param container
     */
    void addChild(Container container);

    /**
     * 设置容器名
     * 
     * @param name
     */
    void setName(String name);

    /**
     * 得到容器名
     * 
     * @return
     */
    String getName();
}

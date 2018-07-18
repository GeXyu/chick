/*
 * $Id: Container.java, 2018年7月18日 下午1:24:06 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzocde.api;

import cn.zzocde.common.HttpRequest;
import cn.zzocde.common.HttpResponse;

/**
 * <p>
 * Title: Container
 * </p>
 * <p>
 * Description:容器抽象
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月18日 下午1:24:06
 * @modified [who date description]
 * @check [who date description]
 */
public interface Container {

    /**
     * 设置父
     * 
     * @param container
     */
    void setParent(Container container);

    /**
     * 得到子
     * 
     * @return
     */
    Container getParent();

    /**
     * 
     * @param child
     */
    void addChild(Container child);

    /**
     * 
     * @param name
     * @return
     */
    Container getChild(String name);

    /**
     * 
     * @param name
     */
    void setName(String name);

    /**
     * 
     * @return
     */
    String getName();

    /**
     * 
     * @param request
     * @param response
     */
    void invoke(HttpRequest request, HttpResponse response);
}

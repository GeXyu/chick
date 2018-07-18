/*
 * $Id: SimpleMapper.java, 2018年7月13日 下午12:41:27 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.core.api.Container;
import cn.zzcode.core.api.Mapper;

/**
 * <p>
 * Title: SimpleMapper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月13日 下午12:41:27
 * @modified [who date description]
 * @check [who date description]
 */
public class SimpleContextMapper implements Mapper {

    private Container container;

    /**
     * @see cn.zzcode.core.api.Mapper#map(cn.zzcode.common.HttpRequest, boolean)
     */
    public Container map(HttpRequest request, boolean update) {
        
        String requestURI = "/";
        
        //String requestURI = request.getRequestURI();
        SimpleContext contenxt = (SimpleContext) container;

        String servletName = contenxt.getServletMapper(requestURI);
        return  contenxt.findChild(servletName);
    }

    /**
     * @see cn.zzcode.core.api.Mapper#setContainer(cn.zzcode.core.api.Container)
     */
    public void setContainer(Container container) {
        this.container = container;
    }

    /**
     * @see cn.zzcode.core.api.Mapper#getContainer()
     */
    public Container getContainer() {
        return this.container;
    }

}

/*
 * $Id: Context.java, 2018年7月10日 下午7:08:10 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.api;

/**
 * <p>
 * Title: Context
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:08:10
 * @modified [who date description]
 * @check [who date description]
 */
public interface Context extends Container {

    /**
     * 添加映射
     * 
     * @param mapper
     * @param servletName
     */
    void addServletMapper(String mapper, String servletName);

    /**
     * 获取映射
     * 
     * @param mapper
     */
    String getServletMapper(String mapper);

    /**
     * 
     */
    void setMapper(Mapper mapper);

    Mapper getMapper();

}

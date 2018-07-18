/*
 * $Id: Wraaper.java, 2018年7月18日 下午1:30:53 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzocde.api;

import javax.servlet.Servlet;

/**
 * <p>
 * Title: Wraaper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月18日 下午1:30:53
 * @modified [who date description]
 * @check [who date description]
 */
public interface Wrapper extends Container {

    /**
     * 
     * @return
     */
    String getServletClass();

    /**
     * 
     * @param className
     */
    void setServletClass(String className);

    /**
     * 
     * @return
     */
    Servlet getServlet();

    /**
     * 
     * @param servlet
     */
    void setServlet(Servlet servlet);
    
    
    
}

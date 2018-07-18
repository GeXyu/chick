/*
 * $Id: Wrapper.java, 2018年7月10日 下午7:08:58 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.api;

import javax.servlet.Servlet;

/**
 * <p>
 * Title: Wrapper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:08:58
 * @modified [who date description]
 * @check [who date description]
 */
public interface Wrapper extends Container {

    Loader getLoader();

    void setLoader(Loader loader);

    String getClassName();

    void setClassName(String className);

    Servlet loadServlet();
}

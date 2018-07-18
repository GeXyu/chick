/*
 * $Id: Loader.java, 2018年7月10日 下午7:03:18 XiuYu.Ge Exp $
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
 * Title: Loader
 * </p>
 * <p>
 * Description:加载器
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:03:18
 * @modified [who date description]
 * @check [who date description]
 */
public interface Loader {

    ClassLoader getClassLoader();

}

/*
 * $Id: SimpleLoader.java, 2018年7月12日 下午10:04:58 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import java.net.URL;
import java.net.URLClassLoader;

import cn.zzcode.core.api.Loader;

/**
 * <p>
 * Title: SimpleLoader
 * </p>
 * <p>
 * Description:基本加载器
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月12日 下午10:04:58
 * @modified [who date description]
 * @check [who date description]
 */
public class SimpleLoader implements Loader {


    /**
     * @see cn.zzcode.core.api.Loader#getClassLoader()
     */
    public ClassLoader getClassLoader() {
        URLClassLoader loader = null;
        URL[] urls = new URL[1];
        urls[0] = SimpleLoader.class.getClassLoader().getResource("/");
        loader = new URLClassLoader(urls);
        return loader;
    }

}

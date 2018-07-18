/*
 * $Id: MyEmbeddedServletContainer.java, 2018年7月17日 上午9:22:00 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.boot;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import cn.zzcode.common.HttpServletConfig;
import cn.zzcode.common.HttpServletContext;

/**
 * <p>
 * Title: ITomcatEmbeddedServletContainerFactory
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月17日 下午12:40:09
 * @modified [who date description]
 * @check [who date description]
 */
@Configuration
public class BootEmbeddedServletContainerFactory implements EmbeddedServletContainerFactory {

    @Resource
    private DispatcherServlet dispatcherServlet;

    /**
     * @see org.springframework.boot.context.embedded.EmbeddedServletContainerFactory#getEmbeddedServletContainer(org.springframework.boot.web.servlet.ServletContextInitializer[])
     */
    @Override
    public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {

        ServletContext servletContext = new HttpServletContext();
        ServletConfig mockServletConfig = new HttpServletConfig();
        for (ServletContextInitializer initializer : initializers) {
            try {
                initializer.onStartup(servletContext);
                dispatcherServlet.init(mockServletConfig);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
        return new BootEmbeddedServletContainer(dispatcherServlet);

    }

}

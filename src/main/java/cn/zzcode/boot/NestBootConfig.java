/*
 * $Id: NestBootConfig.java, 2018年7月21日 下午7:30:01 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.boot;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerException;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;

import cn.zzcode.common.HttpServletConfig;
import cn.zzcode.core.api.Mapper;
import cn.zzcode.core.impl.HttpConnector;
import cn.zzcode.core.impl.SimpleContext;
import cn.zzcode.core.impl.SimpleContextMapper;
import cn.zzcode.core.impl.SimpleLoader;
import cn.zzcode.core.impl.SimpleWrapper;

/**
 * <p>
 * Title: NestBootConfig
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月21日 下午7:30:01
 * @modified [who date description]
 * @check [who date description]
 */
@Configuration
@Component
public class NestBootConfig {

    @Autowired
    private DispatcherServlet dispatcherServlet;

    /**
     * 获取
     * 
     * @return
     */
    private HttpConnector getHttpConnector() {
        SimpleWrapper warrper = new SimpleWrapper();
        warrper.setServlet(dispatcherServlet);

        warrper.setName("org.springframework.web.servlet.DispatcherServlet");
        warrper.setClassName("org.springframework.web.servlet.DispatcherServlet");
        SimpleLoader loader = new SimpleLoader();
        warrper.setLoader(loader);

        SimpleContext context = new SimpleContext();
        Mapper mapper = new SimpleContextMapper();
        mapper.setContainer(context);

        //
        context.addServletMapper("/", "org.springframework.web.servlet.DispatcherServlet");
        context.addChild(warrper);
        context.setMapper(mapper);
        // context.addValue(new RequestValue());

        HttpConnector connector = new HttpConnector();
        connector.setContainer(context);
        System.out.println("itomcat run ....");
        return connector;
    }

    @Configuration
    protected class BootEmbeddedServletContainerFactory implements EmbeddedServletContainerFactory {

        /**
         * @see org.springframework.boot.context.embedded.EmbeddedServletContainerFactory#getEmbeddedServletContainer(org.springframework.boot.web.servlet.ServletContextInitializer[])
         */
        @Override
        public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... initializers) {

            ServletContext servletContext = HttpConnector.getServletContex();
            ServletConfig mockServletConfig = new HttpServletConfig();
            for (ServletContextInitializer initializer : initializers) {
                try {
                    initializer.onStartup(servletContext);
                    dispatcherServlet.init(mockServletConfig);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
            }
            return new BootEmbeddedServletContainer();

        }
    }

    @Configuration
    protected class BootEmbeddedServletContainer implements EmbeddedServletContainer {

        public void start() throws EmbeddedServletContainerException {

            try {
                getHttpConnector().listen();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void stop() throws EmbeddedServletContainerException {
        }

        public int getPort() {
            return 8090;
        }

    }

}

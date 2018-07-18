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

import java.io.IOException;

import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerException;
import org.springframework.web.servlet.DispatcherServlet;

import cn.zzcode.core.api.Mapper;
import cn.zzcode.core.impl.HttpConnector;
import cn.zzcode.core.impl.SimpleContext;
import cn.zzcode.core.impl.SimpleContextMapper;
import cn.zzcode.core.impl.SimpleLoader;
import cn.zzcode.core.impl.SimpleWrapper;

/**
 * @author wcong<wc19920415@gmail.com>
 * @since 16/7/17
 */
public class BootEmbeddedServletContainer implements EmbeddedServletContainer {

    private DispatcherServlet dispatcherServlet;

    public BootEmbeddedServletContainer(DispatcherServlet dispatcherServlet) {
        this.dispatcherServlet = dispatcherServlet;
    }

    public void start() throws EmbeddedServletContainerException {
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
        try {
            connector.listen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() throws EmbeddedServletContainerException {
        // httpServer.stop(1);
    }

    public int getPort() {
        return 8090;
    }

}

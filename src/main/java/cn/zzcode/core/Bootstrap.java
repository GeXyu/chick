/*
 * $Id: Bootstrap.java, 2018年7月10日 下午7:50:32 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core;

import java.io.IOException;

import javax.servlet.ServletException;

import cn.zzcode.core.api.Mapper;
import cn.zzcode.core.impl.HttpConnector;
import cn.zzcode.core.impl.SimpleContext;
import cn.zzcode.core.impl.SimpleContextMapper;
import cn.zzcode.core.impl.SimpleLoader;
import cn.zzcode.core.impl.SimpleWrapper;

/**
 * <p>
 * Title: Bootstrap
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:50:32
 * @modified [who date description]
 * @check [who date description]
 */
public class Bootstrap {

    public static void main(String[] args) throws IOException, ServletException {

        SimpleWrapper warrper = new SimpleWrapper();
        warrper.setName("cn.xiuyu.TestServlet");
        warrper.setClassName("cn.xiuyu.TestServlet");
        SimpleLoader loader = new SimpleLoader();
        warrper.setLoader(loader);

        SimpleContext context = new SimpleContext();
        Mapper mapper = new SimpleContextMapper();
        mapper.setContainer(context);

        //
        context.addServletMapper("/", "cn.xiuyu.TestServlet");
        context.addChild(warrper);
        context.setMapper(mapper);
        // context.addValue(new TestValue());

        HttpConnector connector = new HttpConnector();
        connector.setContainer(context);
        connector.listen();

    }
}

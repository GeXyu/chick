/*
 * $Id: TestController.java, 2018年7月21日 下午7:41:45 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Title: TestController
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月21日 下午7:41:45
 * @modified [who date description]
 * @check [who date description]
 */
@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping("add")
    public String add(HttpServletRequest request) {
        final Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            final String nextElement = headerNames.nextElement();
            final String header = request.getHeader(nextElement);
            System.out.println("key:" + nextElement + " value:" + header);
        }
        return "add result";

    }
}

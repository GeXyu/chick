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

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.write("123");
        writer.flush();
        writer.close();
        return " null";
    }

    @RequestMapping("login")
    public String login(HttpServletRequest request, @RequestParam("username") String username,
            @RequestParam("password") String password) {
        final String result = request.getParameter("username");
        System.out.println(result);
        return username + " -- " + password;
    }
}

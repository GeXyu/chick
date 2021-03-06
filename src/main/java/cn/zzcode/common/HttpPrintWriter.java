/*
 * $Id: HttpPrintWriter.java, 2018年7月30日 下午8:19:32 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * <p>
 * Title: HttpPrintWriter
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月30日 下午8:19:32
 * @modified [who date description]
 * @check [who date description]
 */
public class HttpPrintWriter extends PrintWriter {

    /**
     * @param out
     */
    public HttpPrintWriter(OutputStream out) {
        super(out);
    }

}

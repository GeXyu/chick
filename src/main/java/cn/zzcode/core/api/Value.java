/*
 * $Id: Value.java, 2018年7月10日 下午7:09:09 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.api;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;

/**
 * <p>
 * Title: Value
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月10日 下午7:09:09
 * @modified [who date description]
 * @check [who date description]
 */
public interface Value {

    void invoke(HttpRequest request, HttpResponse response, ValueContext valueContext);
}

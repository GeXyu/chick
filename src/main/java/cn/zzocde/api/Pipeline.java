/*
 * $Id: Pipeline.java, 2018年7月18日 下午1:37:59 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzocde.api;

import cn.zzocde.common.HttpRequest;
import cn.zzocde.common.HttpResponse;

/**
 * <p>
 * Title: Pipeline
 * </p>
 * <p>
 * Description:通道
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月18日 下午1:37:59
 * @modified [who date description]
 * @check [who date description]
 */
public interface Pipeline {

    void invoke(HttpRequest request, HttpResponse response);

}

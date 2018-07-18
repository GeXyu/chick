/*
 * $Id: Mapper.java, 2018年7月13日 下午12:32:22 XiuYu.Ge Exp $
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

/**
 * <p>
 * Title: Mapper
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月13日 下午12:32:22
 * @modified [who date description]
 * @check [who date description]
 */
public interface Mapper {

    Container map(HttpRequest request, boolean update);

    void setContainer(Container container);

    Container getContainer();

}

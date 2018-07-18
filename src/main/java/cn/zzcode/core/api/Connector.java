/*
 * $Id: Connector.java, 2018年7月13日 下午1:14:50 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.api;

/**
 * <p>
 * Title: Connector
 * </p>
 * <p>
 * Description:连接器
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月13日 下午1:14:50
 * @modified [who date description]
 * @check [who date description]
 */
public interface Connector {

    void setContainer(Container container);

    Container getContainer();

}

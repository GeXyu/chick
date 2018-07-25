/*
 * $Id: NestCoreException.java, 2018年7月25日 下午1:34:54 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.exception;

/**
 * <p>
 * Title: NestCoreException
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月25日 下午1:34:54
 * @modified [who date description]
 * @check [who date description]
 */
public class NestCoreException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -7995004262556777529L;

    /**
     * 
     */
    public NestCoreException() {
        super();
        
    }

    /**
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public NestCoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        
    }

    /**
     * @param message
     * @param cause
     */
    public NestCoreException(String message, Throwable cause) {
        super(message, cause);
        
    }

    /**
     * @param message
     */
    public NestCoreException(String message) {
        super(message);
    }

    /**
     * @param cause
     */
    public NestCoreException(Throwable cause) {
        super(cause);
    }

}

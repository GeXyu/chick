/*
 * $Id: SimplePipeline.java, 2018年7月12日 下午7:37:41 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.core.impl;

import java.util.ArrayList;
import java.util.List;

import cn.zzcode.common.HttpRequest;
import cn.zzcode.common.HttpResponse;
import cn.zzcode.core.api.Pipeline;
import cn.zzcode.core.api.Value;
import cn.zzcode.core.api.ValueContext;

/**
 * <p>
 * Title: SimplePipeline
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月12日 下午7:37:41
 * @modified [who date description]
 * @check [who date description]
 */
public class SimplePipeline implements Pipeline {

    private Value basic;
    private List<Value> values = new ArrayList<Value>();

    /**
     * @see cn.zzcode.core.api.Pipeline#invoke(cn.zzcode.common.HttpRequest,
     *      cn.zzcode.common.HttpResponse)
     */
    public void invoke(HttpRequest request, HttpResponse response) {
        new SimpleValueContext().invokeNext(request, response);
    }

    protected class SimpleValueContext implements ValueContext {

        private Integer cursor = 0;

        /**
         * @see cn.zzcode.core.api.ValueContext#invokeNext(cn.zzcode.common.HttpRequest,
         *      cn.zzcode.common.HttpResponse)
         */
        public void invokeNext(HttpRequest request, HttpResponse response) {
            int sub = cursor;
            cursor += 1;
            if (sub < values.size()) {
                values.get(sub).invoke(request, response, this);
            } else {
                basic.invoke(request, response, this);
            }
        }

    }

    /**
     * @see cn.zzcode.core.api.Pipeline#addValue(cn.zzcode.core.api.Value)
     */
    public void addValue(Value value) {
        values.add(value);
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#removeValue(cn.zzcode.core.api.Value)
     */
    public void removeValue(Value value) {
        values.remove(value);
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#setBasic(cn.zzcode.core.api.Value)
     */
    public void setBasic(Value value) {
        this.basic = value;
    }

    /**
     * @see cn.zzcode.core.api.Pipeline#getBasic(cn.zzcode.core.api.Value)
     */
    public Value getBasic() {
        return this.basic;
    }

}

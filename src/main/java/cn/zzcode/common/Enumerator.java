/*
 * $Id: HttpHeader.java, 2018年7月15日 下午7:44:48 XiuYu.Ge Exp $
 * 
 * Copyright (c) 2012 zzcode Technologies Co.,Ltd 
 * All rights reserved.
 * 
 * This software is copyrighted and owned by zzcode or the copyright holder
 * specified, unless otherwise noted, and may not be reproduced or distributed
 * in whole or in part in any form or medium without express written permission.
 */
package cn.zzcode.common;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * Title: HttpHeader
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author XiuYu.Ge
 * @created 2018年7月15日 下午7:44:48
 * @modified [who date description]
 * @check [who date description]
 */
public class Enumerator implements Enumeration<String> {

    private Iterator<String> iterator = null;

    public Enumerator(List<String> list) {
        this(list.iterator());
    }

    public Enumerator(Set<String> set) {
        this(set.iterator());
    }

    public Enumerator(Iterator<String> iterator) {

        super();
        this.iterator = iterator;

    }

    /**
     * @see java.util.Enumeration#hasMoreElements()
     */
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    /**
     * @see java.util.Enumeration#nextElement()
     */
    public String nextElement() {
        return iterator.next();
    }

}

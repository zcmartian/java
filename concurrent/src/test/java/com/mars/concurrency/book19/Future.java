package com.mars.concurrency.book19;

/**
 * <B>概要说明：</B><BR>
 *
 * @author ssk www.8win.com Inc.All rights reserved
 * @version v1.0
 * @date 2018年12月29日 上午 9:42
 */
public interface Future<T> {

    T get() throws InterruptedException;


    boolean done();
}

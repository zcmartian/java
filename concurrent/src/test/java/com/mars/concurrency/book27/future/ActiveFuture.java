package com.mars.concurrency.book27.future;

import com.mars.concurrency.book19.FutureTask;

/**
 * <B>概要说明：</B><BR>
 *
 * @author ssk www.8win.com Inc.All rights reserved
 * @version v1.0
 * @date 2018年12月29日 下午 4:51
 */
public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    public void finish(T result) {

        super.finish(result);
    }
}

package com.mars.concurrency.book29.router;

import com.mars.concurrency.book29.channel.AsyncChannel;
import com.mars.concurrency.book29.channel.Channel;
import com.mars.concurrency.book29.exception.MessageMatcherException;
import com.mars.concurrency.book29.message.Event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <B>概要说明：</B><BR>
 *
 * @author ssk www.8win.com Inc.All rights reserved
 * @version v1.0
 * @date 2019年01月02日 下午 3:42
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Event>, AsyncChannel> routerTable;

    public AsyncEventDispatcher() {

        this.routerTable = new ConcurrentHashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {

        if (!(channel instanceof AsyncChannel)) {
            throw new IllegalArgumentException("The channel must be AsyncChannel Type.");
        }

        this.routerTable.put(messageType, (AsyncChannel) channel);
    }


    @Override
    public void dispatch(Event message) {

        if (routerTable.containsKey(message.getType())) {
            routerTable.get(message.getType()).dispatch(message);
        } else {
            throw new MessageMatcherException("can't match the channel for [" + message.getType() + "] type");
        }
    }

    public void shutdown() {

        routerTable.values().forEach(AsyncChannel::stop);
    }
}

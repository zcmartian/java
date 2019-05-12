package com.mars.concurrency.first.chapter10;

import java.util.Collection;

/***************************************
 * @author:Alex Wang
 * @Date:2017/2/22 QQ:532500648
 * QQ交流群:286081824
 ***************************************/
public interface Lock {

    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    Collection<Thread> getBlockedThread();

    int getBlockedSize();

    class TimeOutException extends Exception {

        public TimeOutException(String message) {
            super(message);
        }
    }

}
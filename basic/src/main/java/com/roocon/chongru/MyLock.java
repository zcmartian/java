package com.roocon.chongru;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author 贾
 * @Date 2019/3/1015:06
 */
public class MyLock  implements Lock{
    private boolean isLocked = false;

    private Thread lockBy = null;

    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        Thread thread = Thread.currentThread();
        while (isLocked ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        lockBy = thread;
//        lockCount++;
        isLocked = true;

    }

    @Override
    public synchronized void unlock() {
        Thread thread = Thread.currentThread();
        if(isLocked && thread == lockBy){
            if(lockCount==0){
                isLocked = false;
                lockBy = null;
                notify();
            }
            lockCount--;
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }



    @Override
    public Condition newCondition() {
        return null;
    }
}

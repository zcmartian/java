package com.roocon.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author 贾
 * @Date 2019/3/1020:03
 */
public class MyLock2  implements Lock {

    private Helper helper = new Helper();

    @Override
    public void lock() {
        helper.tryAcquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        helper.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return helper.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return  helper.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        helper.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return helper.newCondition();
    }

    public class Helper extends AbstractQueuedSynchronizer{

        @Override
        protected boolean tryAcquire(int arg) {
            int state = getState();
            Thread thread = Thread.currentThread();
            if(state == 0){
                if(compareAndSetState(0,arg)){
                    setExclusiveOwnerThread(thread);
                    return true;
                }
            }else if(thread == getExclusiveOwnerThread()){
                setState(state+1);
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {

            if(Thread.currentThread() != getExclusiveOwnerThread()){
                throw  new RuntimeException();
            }
            int state = getState() - arg;

            boolean flag = false;
            if(state == 0){
                setExclusiveOwnerThread(null);
                flag = true;

            }
            setState(state);
            return flag;
        }

        Condition newCondition(){
            return new ConditionObject();
        }
    }



}

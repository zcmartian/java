package com.roocon.chongru;

import java.util.concurrent.locks.Lock;

/**
 * @Author 贾
 * @Date 2019/3/1015:06
 */
public class TestChongru {

    Lock lock = new MyLock();

    public void a(){
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b(){
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        TestChongru c = new TestChongru();
        new Thread(new Runnable() {
            @Override
            public void run() {

                c.a();

            }
        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                lockDecrease.lockDecrease();
//                c.b();
//                lockDecrease.unlock();
//            }
//        }).start();
    }
}

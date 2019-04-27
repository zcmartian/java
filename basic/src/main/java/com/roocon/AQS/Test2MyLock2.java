package com.roocon.AQS;

import com.roocon.chongru.MyLock;
import com.roocon.chongru.TestChongru;

import java.util.concurrent.locks.Lock;

/**
 * @Author 贾
 * @Date 2019/3/1120:39
 */
public class Test2MyLock2 {

    Lock lock = new MyLock2();

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

        Test2MyLock2 c = new Test2MyLock2();
        new Thread(new Runnable() {
            @Override
            public void run() {

                c.a();

            }
        }).start();
    }
}

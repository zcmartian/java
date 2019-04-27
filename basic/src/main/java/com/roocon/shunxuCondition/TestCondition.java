package com.roocon.shunxuCondition;


import com.roocon.shunxudayin.Demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author 贾
 * @Date 2019/3/1220:21
 */
public class TestCondition {
    private int signal = 0;
    private Lock lock = new ReentrantLock();
    private Condition a = lock.newCondition();
    private Condition b = lock.newCondition();
    private Condition c = lock.newCondition();

    public void  a(){
        lock.lock();
        while (signal != 0){
            try {
                a.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        System.out.println("a");
        b.signal();
        lock.unlock();

    }


    public  void  b(){
        lock.lock();
        while (signal != 1){
            try {
                b.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        System.out.println("b");
        c.signal();
        lock.unlock();

    }


    public  void  c(){
        lock.lock();
        while (signal != 2){
            try {
                c.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal = 0;
        System.out.println("c");
        a.signal();
        lock.unlock();

    }

    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(new A(d)).start();
        new Thread(new B(d)).start();
        new Thread(new C(d)).start();
    }
}

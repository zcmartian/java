package com.roocon.AQS;

import com.roocon.chongru.MyLock;
import org.springframework.aop.support.AopUtils;

import java.util.concurrent.locks.Lock;

/**
 * @Author 贾
 * @Date 2019/3/1120:15
 */
public class TestMyLock2 {

    private int value = 0;

    private Lock lock = new MyLock2();

    public int getNext(){
        lock.lock();
        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
         finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {

        TestMyLock2 test = new TestMyLock2();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" "+test.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" "+test.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+" "+test.getNext());
                }
            }
        }).start();
    }
}

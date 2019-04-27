package com.roocon.autom;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 贾
 * @Date 2019/3/1014:09
 */
public class AutomTest {

    private AtomicInteger value = new AtomicInteger(0);

    public int getNext(){
        return  value.getAndIncrement();
    }


    public static void main(String[] args) {

        AutomTest test = new AutomTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int next = test.getNext();
                System.out.println(Thread.currentThread().getName()+next);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                int next = test.getNext();
                System.out.println(Thread.currentThread().getName()+next);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int next = test.getNext();
                System.out.println(Thread.currentThread().getName()+next);
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int next = test.getNext();
                System.out.println(Thread.currentThread().getName()+next);
            }
        }).start();
    }
}

package com.roocon.deadLock;

import com.roocon.thread1.Test;

/**
 * @Author 贾
 * @Date 2019/3/1013:09
 */
public class TestDead {

    private Object o1 = new Object();
    private Object o2 = new Object();

    public  void a(){
        synchronized (o1){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2){
                System.out.println("a");
            }
        }
    }

    public void b(){
        synchronized (o2){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1){
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {
        TestDead t1 = new TestDead();

        new Thread(new Runnable() {
            @Override
            public void run() {
               t1.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.b();
            }
        }).start();
    }

}

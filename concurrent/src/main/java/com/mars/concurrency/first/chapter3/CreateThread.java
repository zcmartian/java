package com.mars.concurrency.first.chapter3;


public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println("==========");
            }
        };
        t1.start();
        t2.start();
        System.out.println("t1 " + t1.getName());
        System.out.println("t2 " + t2.getName());

        Thread t3 = new Thread("MyName");
        Thread t4 = new Thread(() -> {
            System.out.println("Runnable...");
        });

        System.out.println("t3 " + t3.getName());
        System.out.println("t4 " + t4.getName());

        Thread t5 = new Thread(() -> {
            System.out.println("t5  Runnable..." + Thread.currentThread().getName());
        }, "RunnableThread");

        t5.start();
    }
}

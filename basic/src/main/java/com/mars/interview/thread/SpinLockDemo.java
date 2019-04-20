package com.mars.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SpinLockDemo {
    private AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        System.out.println(currentThread().getName()+" try lock");
        while (!atomicReference.compareAndSet(null, currentThread())) {};
        System.out.println(currentThread().getName()+" lock");
    }

    public void unlock() {
        atomicReference.compareAndSet(currentThread(), null);
        System.out.println(currentThread().getName()+" unlock");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.lock();
            try { SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
            spinLockDemo.unlock();
        }, "AA").start();
        try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        new Thread(() -> {
            spinLockDemo.lock();
            spinLockDemo.unlock();
        }, "BB").start();
    }
}

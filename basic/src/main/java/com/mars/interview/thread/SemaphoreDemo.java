package com.mars.interview.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import static java.lang.String.valueOf;
import static java.lang.Thread.currentThread;

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(currentThread().getName()+"\t 抢到车位");
                    try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
                    System.out.println(currentThread().getName()+"\t 3秒后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, valueOf(i)).start();
        }
    }
}

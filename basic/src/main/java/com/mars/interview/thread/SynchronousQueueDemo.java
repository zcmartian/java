package com.mars.interview.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class SynchronousQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(currentThread().getName()+"\t put 1");
                queue.put("1");
                System.out.println(currentThread().getName()+"\t put 2");
                queue.put("2");
                System.out.println(currentThread().getName()+"\t put 3");
                queue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "A").start();

        new Thread(() -> {
            try {
                try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
                System.out.println(currentThread().getName()+"\t"+queue.take());
                try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
                System.out.println(currentThread().getName()+"\t"+queue.take());
                try { TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) { e.printStackTrace();}
                System.out.println(currentThread().getName()+"\t"+queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "").start();
    }
}

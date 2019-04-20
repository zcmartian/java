package com.mars.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) {
        Shared shared = new Shared(new ArrayBlockingQueue<>(3));
        new Thread(() -> {
            System.out.println(currentThread().getName()+"\t 生产线程启动\n\n");
            try {
                shared.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Prod").start();
        new Thread(() -> {
            System.out.println(currentThread().getName()+"\t 消费线程启动\n\n");
            try {
                shared.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Consum").start();
        try { SECONDS.sleep(5);} catch (InterruptedException e) { e.printStackTrace();}
        shared.stop();
    }
}

class Shared {
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String> queue = null;
    private volatile boolean FLAG = true;

    public Shared(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void stop() {
        FLAG = false;
    }

    public void produce() throws InterruptedException {
        String data = null;
        boolean result = false;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            result = queue.offer(data, 2, SECONDS);
            if (result) {
                System.out.println(currentThread().getName() + "\t 生产" + data + "成功");
            } else {
                System.out.println(currentThread().getName() + "\t 生产" + data + "失败");
            }
            try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        }
        System.out.println(currentThread().getName()+"\t 老板叫停,生产结束");
    }

    public void consume() throws InterruptedException {
        String result = null;
        while (FLAG) {
            result = queue.poll(2, SECONDS);
            if (null == result || result.equals("")) {
                FLAG = false;
                System.out.println(currentThread().getName() + "\t 超过2秒钟,消费退出");
                return;
            } else {
                System.out.println(currentThread().getName() + "\t 消费" + result + "成功");
            }
        }
    }
}

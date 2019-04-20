package com.mars.interview.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class VolatileDemo {
    public static void main(String[] args) {
        volatileVisible();
        volatileNotAtomic();
    }

    //volatile不保证原子性
    private static void volatileNotAtomic() {
        MyData myData = new MyData();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.add();
                    myData.addAtomic();
                }
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myData.number);
        System.out.println(myData.atomicInteger);//atomic保证了原子性
    }

    //volatile保证线程可见性
    private static void volatileVisible() {
        MyData myData = new MyData();
        new Thread(() -> {
            System.out.println(currentThread().getName() + "\t come in");
            try {
                SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo100();
            System.out.println(currentThread().getName() + "\t update to " + myData.number);
        }, "AA").start();

        while (myData.number == 0) {
        }
        System.out.println(currentThread().getName() + "\t missionn is over");//不加volatile则不会打印这句话
    }
}

class MyData {
    volatile int number = 0;

    public void addTo100() {
        number = 100;
    }

    /**
     * ++操作不是原子性
     * 字节码指令为3步
     *
     * getfield
     * iconst_1
     * iadd
     * putfield
     *
     * cpu调度不能保证这3步连续进行
     */
    public void add() {
        number += 1;
    }

    AtomicInteger atomicInteger = new AtomicInteger();

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

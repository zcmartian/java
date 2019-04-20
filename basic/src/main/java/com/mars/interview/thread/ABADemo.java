package com.mars.interview.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

import static java.lang.Thread.currentThread;

public class ABADemo {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    private static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(1, new Runnable() {
        @Override
        public void run() {
            System.out.println(atomicReference.compareAndSet(100, 2019)+"\t"+
                    atomicReference.get());
        }
    });
    private static CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        new Thread(() -> {
            //ABA问题的产生
            atomicReference.compareAndSet(100, 101);
            atomicReference.compareAndSet(101, 100);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "T1").start();

        //ABA问题的解决
        int stamp = atomicStampedReference.getStamp();
        new Thread(() -> {
            System.out.println(currentThread().getName()+"\t第1次版本号"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1);
            System.out.println(currentThread().getName()+"\t第2次版本号"+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp()+1);
            System.out.println(currentThread().getName()+"\t第3次版本号"+atomicStampedReference.getStamp());
            countDownLatch.countDown();
        }, "T2").start();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean result = atomicStampedReference.compareAndSet(100, 2019, stamp, stamp+1);
        System.out.println(atomicStampedReference.getStamp());
        System.out.println(result);
    }
}

package com.roocon.cyclic;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author 贾
 * @Date 2019/3/1321:24
 */
public class TestCyclicBarier {

    /**
     *
     * 模拟开会
     *
     * 10个人开会，只要等所有开会的人到齐之后，才开始开会
     *
     */

    public void  meeting(CyclicBarrier barrier){
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"已经进来，正在等待开会.......");
        /**
         * 如果有线程在await()之前抛异常，则barrier的等待数就不会达到对应的数量，不会开启任务。
         */
        try {
            //先进来的线程会等待 ， 等到到达barier指定的数的时候,会唤醒所有线程。
            barrier.await();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        TestCyclicBarier test = new TestCyclicBarier();
        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有人到齐，开始开会....");
            }
        });



        for (int i = 0; i< 10 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.meeting(barrier);
                }
            }).start();
        }
    }
}

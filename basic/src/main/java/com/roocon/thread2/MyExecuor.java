package com.roocon.thread2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 贾
 * @Date 2019/1/419:40
 */
public class MyExecuor {

    public static void main(String[] args) {
        //创建定长线程池
      //  ExecutorService threadPool = Executors.newFixedThreadPool(10);
        //创建 缓存线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();

        for (int i= 0 ; i < 100 ; i++) {
            threadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "is running ... ");
                }
            });
        }
        threadPool.shutdown();
    }
}

package com.roocon.semphore;

import java.util.concurrent.Semaphore;

/**
 * @Author 贾
 * @Date 2019/3/1321:48
 */
public class TestSemphore {

    public void method(Semaphore semaphore){
        try {
            //首先是获取，看是否能获取到，获取到就执行，获取不到就不执行
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName()+"正在执行...");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放掉
        semaphore.release();
    }

    public static void main(String[] args) {
        TestSemphore test = new TestSemphore();
        //设置10个，即每次最多允许10个线程进行访问
        Semaphore semaphore = new Semaphore(10);

        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    test.method(semaphore);
                }
            }).start();
        }
    }
}

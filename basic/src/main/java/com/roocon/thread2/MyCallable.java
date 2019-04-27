package com.roocon.thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Author 贾
 * @Date 2019/1/321:11
 */
public class MyCallable implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("正在计算");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws  Exception{
        MyCallable c = new MyCallable();

        FutureTask<Integer> task = new FutureTask<Integer>(c);

        Thread t = new Thread(task);

        t.start();

        Integer integer = task.get();
        System.out.println("integer = " + integer);
    }
}

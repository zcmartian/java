package com.roocon.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author 贾
 * @Date 2019/3/1419:54
 */
public class TestFuture {



    public static void main(String[] args) {

        Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("正在执行....");
                return 1;
            }
        };

        FutureTask<Integer> task = new FutureTask<>(call);

        Thread t = new Thread(task);

        t.start();

        System.out.println("do something else ... ");

        Integer integer = null;
        try {
            integer = task.get();
        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("计算结果： " + integer);
    }
}

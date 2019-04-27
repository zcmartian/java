package com.roocon.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @Author 贾
 * @Date 2019/3/1421:40
 *
 *
 * 利用 forkJoin 来计算 1+2+3+....+100的和！
 *
 *
 */
public class TestForkJoin extends RecursiveTask<Integer>{
    
    private Integer start;
    private Integer end;

    public TestForkJoin(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if(end-start <= 2 ){
            for (int i = start ; i<= end;i++){
                sum += i;
            }
        }else {
            TestForkJoin t = new TestForkJoin(start,(end+start)/2);
            TestForkJoin t1 = new TestForkJoin((end+start)/2+1,end);

            t.fork();
            t1.fork();

            Integer int1 = t.join();

            Integer int2 = t1.join();
            sum = int1+int2;
        }


        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Integer> task = pool.submit(new TestForkJoin(1, 100));
        try {
            Integer integer = task.get();
            System.out.println("计算结果..... "+integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

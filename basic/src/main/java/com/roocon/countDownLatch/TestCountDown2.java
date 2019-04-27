package com.roocon.countDownLatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.invoke.LambdaConversionException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @Author 贾
 * @Date 2019/3/1222:53
 */
public class TestCountDown2 {
    /**
     *
     * 计算文件中所有的数字之和
     *
     * 每行开一个线程 求和
     *
     * 然后 汇总每个线程之和
     *
     */

    private int[] iarr;

    public TestCountDown2(int line){
        iarr = new int[line];
    }

    public void cal(String line, int index, CountDownLatch latch){
        String[] split = line.split(",");
        for (int i = 0 ; i < split.length; i++){
            int i1 = Integer.parseInt(split[i]);
            iarr[index] +=i1;
        }
        System.out.println("线程计算结束："+iarr[index]);
        latch.countDown();
    }


    public void sum(){
        System.out.println("汇总线程开始执行....");
        int sum = 0;
        for (int i : iarr) {
            sum += i;
        }
        System.out.println("计算总结果为：" + sum );
    }

    public static void main(String[] args) {
        List<String> content = readFile();
        int size = content.size();
        CountDownLatch latch = new CountDownLatch(size);
        TestCountDown2 countDown = new TestCountDown2(size);

        for (int i= 0 ; i < size ; i++){
            final  int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDown.cal(content.get(j),j , latch);
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDown.sum();

    }

    private static List<String> readFile() {
        List<String> content = new ArrayList<>();

        String line = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("G:\\nums.txt")) ;
            while ( (line = br.readLine()) != null){
                content.add(line);
            }

        } catch (Exception e) {

        }
        return content;

    }


}

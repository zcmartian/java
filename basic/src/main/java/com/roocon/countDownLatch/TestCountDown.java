package com.roocon.countDownLatch;

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author 贾
 * @Date 2019/3/1222:53
 */
public class TestCountDown {

    private int[] iarr;

    public TestCountDown(int line){
        iarr = new int[line];
    }

    public void cal(String line,int index){
        String[] split = line.split(",");
        for (int i = 0 ; i < split.length; i++){
            int i1 = Integer.parseInt(split[i]);
            iarr[index] +=i1;
        }
        System.out.println("线程计算结束："+iarr[index]);
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

        TestCountDown countDown = new TestCountDown(size);

        for (int i= 0 ; i < size ; i++){
            final  int j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    countDown.cal(content.get(j),j);
                }
            }).start();
        }

        while (Thread.activeCount() != 2){

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

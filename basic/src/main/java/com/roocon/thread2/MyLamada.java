package com.roocon.thread2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 贾
 * @Date 2019/1/420:09
 */
public class MyLamada {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0 ; i <=100 ; i++){
            list.add(i);
        }
        MyLamada l = new MyLamada();
        int add = l.add(list);
        System.out.println("result = " + add);
    }

    public int add(List<Integer> list){
        //并行流
        list.parallelStream().forEach(System.out::println);
        //普通流
        list.stream().forEach(System.out::println);
        int sum = list.parallelStream().mapToInt(a -> a).sum();
        return sum;
    }
}

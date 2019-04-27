package com.roocon.single;

/**
 * @Author 贾
 * @Date 2019/3/823:10
 */
public class TestSingle {

    public static void main(String[] args) {

//        SingleTon instance = SingleTon.getInstance();
//        SingleTon instance1 = SingleTon.getInstance();
//        SingleTon instance2 = SingleTon.getInstance();
//
//        System.out.println("instance2 = " + instance2);
//        System.out.println("instance1 = " + instance1);
//        System.out.println("instance = " + instance);

        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    SingleTon instance = SingleTon.getInstance();
                    System.out.println("instance = " + instance);
                }
            }).start();

        }
    }
}

package com.roocon.thread2;

/**
 * @Author 贾
 * @Date 2019/1/320:59
 */
public class Demo3 {

    public static void main(String[] args) {
        /**
         * 实现runable方法 的匿名内部类
         */
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("线程执行了....");
            }
        });
        thread.start();


        new Thread(){
            @Override
            public void run() {
                System.out.println("类的匿名内部类线程执行了....");
            }
        }.start();
    }
}

package com.roocon.thread2;

/**
 * @Author 贾
 * @Date 2019/1/320:52
 */
public class MyRunable implements Runnable {
    public void run() {
        while (true){
            System.out.println("线程执行了...");
        }
    }


    public static void main(String[] args) {
        Thread t = new Thread(new MyRunable());
        t.start();
    }
}

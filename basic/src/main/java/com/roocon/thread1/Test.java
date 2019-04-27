package com.roocon.thread1;

/**
 * @Author 贾
 * @Date 2019/1/220:27
 */
public class Test {
    public static void main(String[] args) {
        Demo d1 = new Demo("first");

        Demo d2 = new Demo("second");

        d1.start();
        d2.start();
    }
}

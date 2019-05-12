package com.mars.concurrency.first.chapter3;

public class CreateThread4 {

    private static int counter = 1;

    public static void main(String[] args) {


        //创建线程时指定jvm 栈大小
        Thread t1 = new Thread(null, new Runnable() {
            @Override
            public void run() {
                try {
                    add(1);
                } catch (Error e) {
                    System.out.println(counter);
                }
            }

            private void add(int i) {
                counter++;
                add(i + 1);
            }
        }, "Test", 1 << 24);
        t1.start();
    }
}

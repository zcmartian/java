package com.mars.concurrency.first.chapter1;


public class TryConcurrency {

    public static void main(String[] args) {
        Thread t = new Thread("READ-Thread") {
            @Override
            public void run() {
                println(Thread.currentThread().getName());
                readFromDataBase();
            }
        };
        //只是调用实例方法的时候 返回 main
        //t.run();

        t.start();

        new Thread("WRITE-Thread") {
            @Override
            public void run() {
                println(Thread.currentThread().getName());
                writeDataToFile();
            }
        }.start();
    }

    private static void readFromDataBase() {
        //read data from database and handle it.
        try {
            println("Begin read data from db.");
            Thread.sleep(1000 * 3L);
            println("Read data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void writeDataToFile() {
        try {
            println("Begin write data to file.");
            Thread.sleep(2000 * 2L);
            println("Write data done and start handle it.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        println("The data handle finish and successfully.");
    }

    private static void println(String message) {
        System.out.println(message);
    }
}

package com.mars.concurrency.second.classloader.chapter1;

import java.util.concurrent.atomic.AtomicBoolean;

public class ClinitThreadTest {

    public static void main(String[] args) {

        System.out.println(System.getProperty("sun.boot.class.path"));

        new Thread(() -> new SimpleObject()).start();

        new Thread(() -> new SimpleObject()).start();
    }

    static class SimpleObject {

        private static AtomicBoolean init = new AtomicBoolean(true);

        static {
            System.out.println(Thread.currentThread().getName() + " I will be initial");
            while (init.get()) {

            }
            System.out.println(Thread.currentThread().getName() + " I am finished initial.");
        }
    }
}


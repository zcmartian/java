package com.mars.concurrency.first.chapter6;

public class ThreadInterrupt {

    private static final Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

//        test1();
        test2();
    }

    private static void test2() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {

                }
            }
        };

        t.start();
        Thread main = Thread.currentThread();
        Thread t2 = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                main.interrupt();
                System.out.println("interrupt");
            }
        };

        t2.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test1() throws InterruptedException {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (MONITOR) {
                        try {
                            MONITOR.wait(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("from catch:" + isInterrupted());
                        }
                    }
                }
            }
        };

        t.start();
        Thread.sleep(100);
        System.out.println("in main before interrupt:" + t.isInterrupted());
        t.interrupt();
        System.out.println("in main after interrupt:" + t.isInterrupted());
        t.stop();

//        Thread t = new Thread(() -> {
//            while (true) {
//                synchronized (MONITOR) {
//                    try {
//                        MONITOR.wait(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        System.out.println(Thread.interrupted());
//                    }
//                }
//            }
//        });
    }
}

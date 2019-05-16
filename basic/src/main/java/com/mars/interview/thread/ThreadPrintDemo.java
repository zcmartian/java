package com.mars.interview.thread;

class ThreadPrintDemo {

    static int num = 0;
    static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        long time1 = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            for (; 1000000 > num; ) {
                if (!flag && (num == 0 || ++num % 2 == 0)) {
                    System.out.println(Thread.currentThread().getName() + " -> " + num);
                    flag = true;
                }
            }
        }
        );

        Thread t2 = new Thread(() -> {
            for (; 1000000 > num; ) {
                if (flag && (++num % 2 != 0)) {
                    System.out.println(Thread.currentThread().getName() + " -> " + num);
                    flag = false;
                }
            }
        }
        );

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}

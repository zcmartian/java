package com.roocon.threadLocal;

/**
 * @Author 贾
 * @Date 2019/3/1222:13
 */
public class TestThreadLocal {
    /**
     *
     * 统计每个线程的执行次数
     *
     */

    ThreadLocal<Integer> cout = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };


    public int getValue(){
        Integer integer = cout.get();
        integer+=1;
        cout.set(integer);
        return integer;
    }

    public static void main(String[] args) {
        TestThreadLocal t = new TestThreadLocal();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + t.getValue());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + t.getValue());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + t.getValue());
                    try {
                        Thread.sleep(800);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

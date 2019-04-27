package com.roocon.syn;

/**
 * @Author 贾
 * @Date 2019/3/912:03
 */
public class TestSyn {
    /**
     * 测试可重入锁
     *
     *
     * 多线程多实例，synchronized 不能 锁住
     * 多线程单实例 ， synchronized 可以锁住
     */

    public synchronized void a()  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("a");
    }

    public synchronized void b(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("b");
    }

    public static void main(String[] args) {
//1.测试单线程的
//        TestSyn t = new TestSyn();
//        t.a();
//        t.b();

        //测试多线程单个实例
        TestSyn t1 = new TestSyn();
       TestSyn t2 = new TestSyn();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t1.a();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t2.b();
            }
        }).start();
    }





}

package com.roocon.thread.t7;

/**
 * ��֤�ɼ��Ե�ǰ��
 * <p>
 * ����߳��õ�����ͬһ�����������Ǳ�֤���˵ġ�
 *
 *  */
public class Demo {

    public volatile int a = 1;

    public synchronized int getA() {
        return a++;
    }

    public int unSynchronizedA() {
        int i = 0;
        i = i * 10000;
        i = i + 3000;
        int value = 1;
        int t = value / i;
        return a++;
    }

    public synchronized void setA(int a) {
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.a = a;
    }

    public static void main(String[] args) {

        Demo demo = new Demo();

        /*
        author:cyd
        374
        404
        372
        371
        371    volatile���ܱ�֤ԭ�Ӳ�����
        365
        369
        367
        366
         */
        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(demo.unSynchronizedA());
                }
            }).start();
        }

        demo.a = 10;

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(demo.a);
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("���յĽ��Ϊ��" + demo.getA());

    }

}

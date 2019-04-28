package com.roocon.thread.ta4;

public class Main {

    private int value;
    private MyLock2 lock = new MyLock2();

    public int next() {
        lock.lock();

        try {
            Thread.sleep(300);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            lock.unlock();
        }
    }

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        lock.unlock();
    }

    public static void main(String[] args) {

        Main m = new Main();

        new Thread(new Runnable() {

            @Override
            public void run() {
                m.a();
            }
        }).start();

        for (int i = 0; i < 20; i++) {
            /*
            author:cyd
            Thread-2:-----enq is running
            Thread-2:-----enq is running
            //˵������Ϊ��ʱ����Ҫ��ʼ���յ�Node��
            Thread-2:------acquireQueued is running
            Thread-2:------before wait status is 0
            Thread-2:------after wait status is -1
            Thread-2:------acquireQueued is running
            Thread-2:------before wait status is -1
            Thread-2:------is park
            Thread-6:------acquireQueued is running
            Thread-6:------before wait status is 0
            Thread-6:------after wait status is -1
            Thread-6:------acquireQueued is running
            Thread-6:------before wait status is -1
            Thread-6:------is park
            Thread-3:------acquireQueued is running
            Thread-3:------before wait status is 0
            Thread-3:------after wait status is -1
            Thread-3:------acquireQueued is running
            Thread-3:------before wait status is -1
            Thread-3:------is park
            Thread-7:------acquireQueued is running
            Thread-7:------before wait status is 0
            Thread-7:------after wait status is -1
            Thread-7:------acquireQueued is running
            Thread-7:------before wait status is -1
            Thread-7:------is park
            //˵��ÿ���ڵ㶼���������Ի�ȡͬ��״̬��
            δ��ȡ��ʱ���Ὣ�Լ���waitStatus��ΪSIGNAL��Ȼ��������park���ýڵ��е��̡߳�
            ...
            Thread-2:------acquireQueued is running
            Thread-2:------is unpark
            Thread-6:------acquireQueued is running
            1
            Thread-6:------is unpark
            Thread-3:------acquireQueued is running
            2
            Thread-3:-----is unpark
            Thread-7:------acquireQueued is running
            3
            Thread-7:------is unpark
            ˵�����ѣ�unpark���̺߳���ȷִ�д�ӡ��䣻���һ��ѣ�unpark�����߳���������park�����߳����Ӧ����ѭFIFO��ԭ��
             */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(m.next());
                }
            }).start();
        }
    }

}

package com.exercise;

import java.util.ArrayList;
import java.util.List;

public class ThreadCommunication {
    static List<Integer> list = new ArrayList<>();
    boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <= 1000; i++) {
            new Thread(new Producer(i), "�������߳�").start();
            Thread.sleep(1);
            new Thread(new Consumer(), "�������߳�").start();
        }
    }

    static class Producer implements Runnable {
        Integer i;

        public Producer(Integer i) {
            this.i = i;
        }

        @Override
        public void run() {
            synchronized (list) {
                list.add(i);
                System.out.println("�����������ˣ�" + i);
                list.notify();
            }
        }
    }

    static class Consumer implements Runnable {

        @Override
        public void run() {
            synchronized (list) {
                while (list.size() < 1) {
                    try {
                        System.out.println("�����ߵȴ���ʼ������");
                        list.wait();
                        System.out.println("�����ߵȴ�����������");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("�����������ˣ�" + list.remove(0));
                ;
            }
        }
    }
}


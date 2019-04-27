package com.roocon.zixuan;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author 贾
 * @Date 2019/3/1012:49
 */
public class TestZiXuan {

    /**
     *
     * 所有的线程完成之后在打印一句话
     *
     */

    public static void main(String[] args) {
//         new Thread(new Runnable() {
//             @Override
//             public void run() {
//                 System.out.println(Thread.currentThread().getName()+"执行了....");
//             }
//         }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"执行了....");
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"执行了....");
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"执行了....");
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"执行了....");
//            }
//        }).start();
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+"执行了....");
//            }
//        }).start();

//        while (true){
//            int i = Thread.activeCount();
//            System.out.println(i);
//            if(Thread.activeCount()==1) {
//                System.out.println("所有的线程执行完成....");
//            }
//            System.out.println("1111");
//        }

        int i = Thread.activeCount();
           System.out.println(i);

//        // 获取java线程的管理MXBean
//        ThreadMXBean tmxb = ManagementFactory.getThreadMXBean();
//        // 不需要获取同步的Monitor和synchronizer信息，仅获取线程和线程堆栈信息
//        ThreadInfo[] threadInfos = tmxb.dumpAllThreads(false, false);
//        // 遍历线程信息，打印出ID和名称
//        for (ThreadInfo info : threadInfos) {
//            System.out.println("[" + info.getThreadId() + "] " + info.getThreadName());
//        }


        System.out.println(Thread.activeCount());
        Thread.currentThread().getThreadGroup().list();



//        while (Thread.activeCount() != 1){}
//        System.out.println("所有的线程执行完成....");
    }

}

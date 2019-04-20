package com.mars.interview.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.String.valueOf;
import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ReadWriteLockDemo {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();
        for (int i = 0; i < 6; i++) {
            final int tmp = i;
            new Thread(() -> {
                demo.put(tmp+"", tmp+"");
            }, valueOf(i)).start();
        }
        for (int i = 0; i < 6; i++) {
            final int tmp = i;
            new Thread(() -> {
                demo.get(tmp+"");
            }, valueOf(i)).start();
        }
    }

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(currentThread().getName()+"\t 正在写入:"+key);
            try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
            map.put(key, value);
            System.out.println(currentThread().getName()+"\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(currentThread().getName()+"\t 正在读取:"+key);
            try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
            Object result = map.get(key);
            System.out.println(currentThread().getName()+"\t 读取完成"+result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    public void clean() {
        map.clear();
    }
}

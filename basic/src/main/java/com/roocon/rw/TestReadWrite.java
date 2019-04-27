package com.roocon.rw;

import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author 贾
 * @Date 2019/3/1121:09
 */
public class TestReadWrite {

    private Map<String, Object> map = new HashMap<>();

    private ReadWriteLock rwl = new ReentrantReadWriteLock();

    private Lock r = rwl.readLock();

    private Lock wr = rwl.writeLock();

    /**
     * 锁降级：
     *      就是讲些锁降级为读锁
     */
    public void testLockDe(){
        r.lock();

        //先释放读锁
        r.unlock();
        //然后家读锁
        wr.lock();
        map.put("key","value");
        //为了防止多条写线程竞争到写锁，先加读锁，在释放写锁，保证后续读的数据是正确的
        r.lock();
        //释放写锁
        wr.unlock();

        Object key = map.get("key");

        r.unlock();
        return ;

    }


    public Object getKey(String key) {
        r.lock();
        Object obj;


        obj = map.get(key);


        r.unlock();


        return obj;
    }

    public void putKey(String key, Object value) {

        wr.lock();
        System.out.println(Thread.currentThread().getName() + " 正在写操作...");
        try {
            Thread.sleep(3000);
            map.put(key, value);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        } finally {
            wr.unlock();
            System.out.println(Thread.currentThread().getName() + " 写操作完毕...");
        }
    }
}

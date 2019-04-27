package com.roocon.rw;

import sun.awt.SunHints;

/**
 * @Author 贾
 * @Date 2019/3/1121:18
 */
public class TestRW {
    /**
     * 读写锁：
     *  1.读锁与读锁 共享
     *  2. 读锁和写锁互斥
     *  3.写锁和写锁互斥
     *
     * @param args
     */

    public static void main(String[] args) {
        TestReadWrite trw = new TestReadWrite();

        trw.putKey("key1","value1");
        trw.putKey("key2","value2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                trw.getKey("key1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                trw.getKey("key2");
            }
        }).start();
    }
}

package com.mars.concurrency.second.concurrent.chapter5;

/**
 * SharedResource
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    /**
     * ★★★★★ synchronized★★★★★
     * <p>
     * 在verify 的时候name 和address 在多线程的情况下会出现数据问题
     * <p>
     * gate 属于共享资源， pass 为临界值，对共享资源操作会发生竞争
     * 处理办法是在 临界值上加this锁
     * 临界值
     *
     * @param name
     * @param address
     */
    public synchronized void pass(String name, String address) {
        this.counter++;
        /*race*/
        this.name = name;
        this.address = address;
        verify();
    }

    private void verify() {
        if (this.name.charAt(0) != this.address.charAt(0)) {
            System.out.println("*******BROKEN********" + toString());
        }
    }

    public synchronized String toString() {
        return "No." + counter + ":" + name + "," + address;
    }
}
package com.mars.concurrency.second.concurrent.chapter8;
public interface Future<T> {

    T get() throws InterruptedException;

}
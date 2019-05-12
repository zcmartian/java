package com.mars.concurrency.second.concurrent.chapter1;

import com.mars.concurrency.annoations.NotRecommend;
import com.mars.concurrency.annoations.ThreadSafe;

@ThreadSafe
@NotRecommend
public class SingletonObject1 {

    /**
     * can't lazy load.
     * 好长时间不引用 会浪费内存
     */
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {
        //empty
    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}
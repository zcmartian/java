package com.roocon.waitnotify;

/**
 * @Author 贾
 * @Date 2019/3/1122:38
 */
public class TestWait {

    private volatile int signal = 0;

    public void set(){
        signal = 1;
    }

    public int get(){
        return signal;
    }

}

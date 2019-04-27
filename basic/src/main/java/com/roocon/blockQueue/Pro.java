package com.roocon.blockQueue;

import java.util.Random;

/**
 * @Author 贾
 * @Date 2019/3/1717:24
 */
public class Pro implements Runnable {

    private Tmall tmall;

    public Pro(Tmall tmall) {
        this.tmall = tmall;
    }

    @Override
    public void run() {
        tmall.push(new Random().nextInt(100));
    }
}

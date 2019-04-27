package com.roocon.blockQueue;

/**
 * @Author 贾
 * @Date 2019/3/1717:26
 */
public class Consum implements Runnable {

    private Tmall tmall ;

    public Consum(Tmall tmall){
        this.tmall = tmall;
    }

    @Override
    public void run() {
        tmall.take();
    }
}

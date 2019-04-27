package com.roocon.blockQueue;

/**
 * @Author 贾
 * @Date 2019/3/1717:08
 */
public class TestBlockQueue {


    public static void main(String[] args) {

        Tmall tmall = new Tmall();

        Pro p = new Pro(tmall);

        Consum c = new Consum(tmall);

        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();


        new Thread(c).start();
        new Thread(c).start();
        new Thread(c).start();

    }


}

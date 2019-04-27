package com.roocon.thread2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author 贾
 * @Date 2019/1/419:31
 */
public class MyTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        /**
         *
         *  延迟5000h毫秒执行之后 每个1秒中执行一次
         * timer.schedule(timerTask,5000,1000);
         */

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer is running ... ");
            }
        }, 0, 1000);
    }
}

package com.roocon.exchange;

import java.util.concurrent.Exchanger;

/**
 * @Author 贾
 * @Date 2019/3/1322:11
 */
public class TestExchange {

    public void a(Exchanger<String> exch){
        System.out.println("a方法开始执行了...");

        try {
            Thread.sleep(2000);
            System.out.println("a开始抓取数据...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "4556";
        try {
            System.out.println("a开始等待...");
            exch.exchange(res);
            System.out.println("等待交换数据....");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void b(Exchanger<String> exch){
        System.out.println("b方法开始执行了...");

        try {
            Thread.sleep(6000);
            System.out.println("b开始抓取数据...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String res = "4556";
        try {
            String value = exch.exchange(res);
            System.out.println("交换数据....");
            System.out.println("数据结果："+value.equals(res));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TestExchange test = new TestExchange();
        Exchanger<String> exch = new Exchanger<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.a(exch);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.b(exch);
            }
        }).start();
    }
}

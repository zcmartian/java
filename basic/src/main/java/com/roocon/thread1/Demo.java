package com.roocon.thread1;

/**
 * @Author 贾
 * @Date 2019/1/220:25
 */
public class Demo  extends Thread{
    public Demo(){}
    public Demo(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName()+"继承线程执行了...");
    }


}

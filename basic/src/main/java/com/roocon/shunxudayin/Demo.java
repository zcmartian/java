package com.roocon.shunxudayin;



/**
 * @Author 贾
 * @Date 2019/3/1220:06
 */
public class Demo {
    /**
     *
     * 普通方法实现 顺序 abc abc abc
     *
     *
     */
    private int signal = 0;

    public synchronized  void  a(){

        while (signal != 0){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        System.out.println("a");
        notifyAll();
    }


    public synchronized  void  b(){
        while (signal != 1){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal++;
        System.out.println("b");
        notifyAll();
    }


    public synchronized  void  c(){
        while (signal != 2){
            try {
                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        signal = 0;
        System.out.println("c");
        notifyAll();
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        new Thread(new A(d)).start();
        new Thread(new B(d)).start();
        new Thread(new C(d)).start();
    }
}
class A implements Runnable{

    private Demo demo ;

    public A(Demo demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.a();
        }
    }


}
class B implements Runnable{

    private Demo demo ;

    public B(Demo demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.b();
        }
    }
}

class C implements Runnable{

    private Demo demo ;

    public C(Demo demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while (true) {
            demo.c();
        }
    }
}



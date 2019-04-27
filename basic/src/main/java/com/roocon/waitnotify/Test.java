package com.roocon.waitnotify;

/**
 * @Author 贾
 * @Date 2019/3/1122:40
 *
 *
 * wait()/notify():
 *      1.方法必须放在同步代码块中执行
 *      2.必须是使用同一个对象调用，否则会出现错误，
 *
 *      wait()方法：某对象调用此方法，则此对象会释放锁
 *
 *
 */
public class Test {
    TestWait tw = new TestWait();

    public static void main(String[] args) {

        TestWait t = new TestWait();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (t){
                    while (t.get() != 1) {
                         try {
                            t.wait(); //用对象t调用，声明 t 对象释放锁
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                System.out.println("执行了信号....");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (t) {
                    t.set();
                    t.notify();
                    System.out.println("设置完成....");
                }
            }
        }).start();
    }
}

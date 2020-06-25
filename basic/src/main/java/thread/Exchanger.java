package thread;

/**
 * Created by mars on 2017/3/14.
 */
public class Exchanger {
    public static void main(String... args) throws InterruptedException {
        java.util.concurrent.Exchanger<String> exchanger = new java.util.concurrent.Exchanger<>();
        ThreadA threadA = new ThreadA(exchanger);
        ThreadB threadB = new ThreadB(exchanger);
        threadA.start();
        threadB.start();
    }

    static class ThreadA extends Thread {
        private java.util.concurrent.Exchanger<String> exchanger;

        public ThreadA(java.util.concurrent.Exchanger<String> exchanger) {
            super();
            this.exchanger = exchanger;
        }

        public void run() {
            try {
                System.out.println("线程A已经进入");
                System.out.println("在线程A中得到线程B的值=" + exchanger.exchange("中国人A"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {
        private java.util.concurrent.Exchanger<String> exchanger;

        public ThreadB(java.util.concurrent.Exchanger<String> exchanger) {
            super();
            this.exchanger = exchanger;
        }

        public void run() {
            try {
                System.out.println("线程B已经进入");
                Thread.sleep(2000);
                System.out.println("在线程B中得到线程A的值=" + exchanger.exchange("中国人B"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



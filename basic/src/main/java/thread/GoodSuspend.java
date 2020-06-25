package thread;

/**
 * Created by marszhou on 16/1/1.
 */
public class GoodSuspend {
    public static Object u = new Object();

    public static void main(String[] args) throws InterruptedException {
        ChangObjectThread t1 = new ChangObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();

        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec");
        Thread.sleep(2000);
        System.out.println("resume t2");
        t1.resumeMe();
    }

    public static class ChangObjectThread extends Thread {
        volatile static boolean isSuspend = false;

        public void suspendMe() {
            isSuspend = true;
            System.out.println("t1 is suspend");
        }

        public void resumeMe() {
            isSuspend = false;
            synchronized (this) {
                notify();
                System.out.println("t1 is resumed");
            }
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (isSuspend) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                synchronized (u) {
                    System.out.println("in ChangeObjectThread");
                }

                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    System.out.println("in ReadObjectThread");
                }
                Thread.yield();
            }
        }
    }
}

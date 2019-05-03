import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.TimeUnit.SECONDS;

public class IntLock implements Runnable {
    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if(lock == 1) {
                lock1.lockInterruptibly();
                try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(lock1.isHeldByCurrentThread()) lock1.unlock();
            if(lock2.isHeldByCurrentThread()) lock2.unlock();
            System.out.println(currentThread().getName()+":线程退出");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        try { SECONDS.sleep(2);} catch (InterruptedException e) { e.printStackTrace();}
        t2.interrupt();
    }
}

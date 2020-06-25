package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

public class TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            if(lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(currentThread().getName()+" get lock success");
                Thread.sleep(6000);
            } else {
                System.out.println(currentThread().getName()+" get lock fail");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) lock.unlock();
        }
    }

    public static void main(String[] args) {
        TimeLock lock = new TimeLock();
        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);
        t1.start();
        t2.start();
    }
}

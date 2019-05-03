import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by marszhou on 16/1/3.
 */
public class ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private static Lock readLock = readWriteLock.readLock();
    private static Lock writeLock = readWriteLock.writeLock();
    private int value;

    public static void main(String[] args) {
        final ReadWriteLockDemo demo = new ReadWriteLockDemo();
        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleRead(readLock);//读锁并发读
//                    demo.handleRead(lock);//独占锁,读写都要加锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    demo.handleWrite(writeLock, new Random().nextInt());//写锁独占写
//                    demo.handleWrite(lock, new Random().nextInt());//独占锁,读写都要加锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 18; i < 20; ++i) {
            new Thread(writeRunnable).start();
        }

        for (int i = 0; i < 18; ++i) {
            new Thread(readRunnable).start();
        }
    }

    public Object handleRead(Lock lock) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(System.currentTimeMillis() + "@read ," + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);
            value = index;
            System.out.println(System.currentTimeMillis() + "@write ," + value);
        } finally {
            lock.unlock();
        }
    }
}

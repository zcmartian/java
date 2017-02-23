import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by mars on 2017/2/23.
 */
public class CachedData {
    int data = 0;
    volatile boolean cacheValid;
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    void processCachedData() {
        rwl.readLock().lock();//@1
        while (!cacheValid) {
            System.out.println("enter lock");
            // Must release read lock before acquiring write lock
            rwl.readLock().unlock();//@4
            rwl.writeLock().lock();//@2
            // Recheck state because another thread might have acquired
            //   write lock and changed state before we did.
            System.out.println("before add " + data);
            if (!cacheValid) {//@3
                data += 1;
                cacheValid = true;
                System.out.println(data);
            }
            // Downgrade by acquiring read lock before releasing write lock
            rwl.readLock().lock();
            rwl.writeLock().unlock(); // Unlock write, still hold read
        }

        use(data);
        rwl.readLock().unlock();
    }

    private void use(int data) {
        System.out.println(Thread.currentThread() + " " + data);
    }

    public static void main(String ... args) throws InterruptedException {
        CachedData cachedData = new CachedData();
        MyThread thread1 = new MyThread(cachedData);
        MyThread thread2 = new MyThread(cachedData);
        MyThread thread3 = new MyThread(cachedData);
        MyThread thread4 = new MyThread(cachedData);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

class MyThread extends Thread {
    CachedData cachedData;

    public MyThread(CachedData cachedData) {
        this.cachedData = cachedData;
    }

    @Override
    public void run() {
        cachedData.processCachedData();
    }
}

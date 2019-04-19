import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mars on 2017/3/13.
 */
public class ReentryLock implements Runnable {
    private static final TestObj obj = new TestObj(0);

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String... args) throws InterruptedException {
        ReentryLock reentryLock = new ReentryLock();
        ReentryLock reentryLock2 = new ReentryLock();
        Thread thread1 = new Thread(reentryLock);
        Thread thread2 = new Thread(reentryLock2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(obj.getValue());
    }

    private void increase() {
        int i = obj.getValue();
        i += 1;
        obj.setValue(i);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; ++i) {
            try {
                lock.lock();
                increase();
            } finally {
                lock.unlock();
            }
        }
    }

}

class TestObj {
    int value;

    public TestObj(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.currentThread;

/**
 * 1 线程     操作(方法)      资源类
 * 2 判断     干活           通知
 * 3 防止虚假唤醒
 */
public class ProducerConsumerTraditional {
    public static void main(String[] args) {
        ShareData shareData = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
    }

    static class ShareData {
        private int number = 0;
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void increment() throws InterruptedException {
            lock.lock();
            try {
                // 判断
                while (number != 0) {
                    // 等待,不能生产
                    condition.await();
                }
                // 干活
                number++;
                // 通知唤醒
                System.out.println(currentThread().getName() + "\t" + number);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void decrement() throws InterruptedException {
            lock.lock();
            try {
                // 判断
                while (number == 0) {
                    // 等待,不能消费
                    condition.await();
                }
                // 干活
                number--;
                // 通知唤醒
                System.out.println(currentThread().getName() + "\t" + number);
                condition.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
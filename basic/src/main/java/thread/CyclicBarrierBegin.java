package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by mars on 2017/3/14.
 */
public class CyclicBarrierBegin {
    public static void main(String... args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("全部到了!"));

        MyThread2[] thread2s = new MyThread2[5];
        for (int i = 0; i < 5; i++) {
            thread2s[i] = new MyThread2(cyclicBarrier);
        }
        for (int i = 0; i < 5; i++) {
            thread2s[i].start();
        }
    }

    private static
    class MyThread2 extends Thread {
        private CyclicBarrier cyclicBarrier;

        public MyThread2(CyclicBarrier cyclicBarrier) {
            super();
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {
            try {
                Thread.sleep((int) (Math.random() * 1000));
                System.out.println(Thread.currentThread().getName() + " 到了! " + System.currentTimeMillis());
                cyclicBarrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


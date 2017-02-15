import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Consumer implements Runnable {

    protected BlockingQueue<String> queue = null;
    private CountDownLatch countDownLatch;

    public Consumer(BlockingQueue<String> queue, CountDownLatch countDownLatch) {
        this.queue = queue;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
        try {
            System.out.println(queue.take());
            System.out.println(queue.take());
            System.out.println(queue.take());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end!");
        countDownLatch.countDown();
    }
}

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Producer implements Runnable {

    protected BlockingQueue<String> queue = null;
    private CountDownLatch countDownLatch;

    public Producer(BlockingQueue<String> queue, CountDownLatch countDownLatch) {
        this.queue = queue;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
        try {
            queue.put("1");
            Thread.sleep(3000);
            queue.put("2");
            Thread.sleep(5000);
            queue.put("3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end!");
        countDownLatch.countDown();
    }
}

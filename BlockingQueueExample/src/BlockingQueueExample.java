import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " start!");
        BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
        Producer producer = new Producer(queue, countDownLatch);
        Consumer consumer = new Consumer(queue, countDownLatch);

        Thread p = new Thread(producer, "Producer ");
        p.start();
        Thread c = new Thread(consumer, "Comsumer ");
        c.start();
        countDownLatch.await();
//        p.join();
//        c.join();
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " end!");

    }

}

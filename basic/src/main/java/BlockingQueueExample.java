import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " start!");
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(1024);
        Producer producer = new BlockingQueueExample().new Producer(queue, countDownLatch);
        Consumer consumer = new BlockingQueueExample().new Consumer(queue, countDownLatch);

        Thread p = new Thread(producer, "Producer ");
        p.start();
        Thread c = new Thread(consumer, "Comsumer ");
        c.start();
        countDownLatch.await();
//        p.join();
//        c.join();
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " end!");

    }

    class Consumer implements Runnable {

        protected BlockingQueue<String> queue = null;
        private CountDownLatch countDownLatch;

        public Consumer(BlockingQueue<String> queue, CountDownLatch countDownLatch) {
            this.queue = queue;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
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

    class Producer implements Runnable {

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
}





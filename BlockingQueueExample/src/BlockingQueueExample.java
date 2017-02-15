import java.util.concurrent.*;

public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " start!");
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		Thread p = new Thread(producer, "Producer ");
		p.start();
		Thread c = new Thread(consumer, "Comsumer ");
		c.start();
		p.join();
		c.join();
		System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " end!");

	}

}

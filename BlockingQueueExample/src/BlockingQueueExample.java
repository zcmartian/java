import java.util.concurrent.*;

public class BlockingQueueExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1024);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);

		new Thread(producer).start();
		new Thread(consumer).start();
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
		Thread.sleep(4000);
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end!");
	}

}

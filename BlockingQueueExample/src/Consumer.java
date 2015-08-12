import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

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
	}

	protected BlockingQueue<String> queue = null;

	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
}

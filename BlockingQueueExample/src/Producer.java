import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;

	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
		try {
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end!");
	}
}

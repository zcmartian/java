import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest implements Runnable {
	public void run() {
		synchronized (this) {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		//BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
		BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
		for (int i = 0; i < 10; i++) {
			//executor.execute(new Thread(new ThreadPoolTest(), "TestThread".concat("" + i)));
			final int index = i;
			try {
				executor.execute(new Runnable() {
					public void run() {
						System.out.println(String.format("thread %d finished", index));
					}
				});
			} catch (RejectedExecutionException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			//int threadSize = queue.size();
			//System.out.println("线程队列大小为-->" + threadSize);
			System.out.println(executor.toString());
		}
		//System.out.println(executor.toString());
		executor.shutdown();
	}
}
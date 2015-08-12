import java.util.concurrent.*;

public class ThreadPoolExecutorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int corePoolSize = 3;
		int maxPoolSize = 6;
		long keepAliveTime = 1;

		ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
				TimeUnit.DAYS, new LinkedBlockingQueue<Runnable>());

		for (int i = 0; i < 20; i++) {
			final int index = i;
			threadPoolExecutor.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(String.format("thread %d finished", index));
				}
			});
		}
		threadPoolExecutor.shutdown();
	}
}

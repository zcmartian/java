public class ThreadExample extends Thread {

	private static int n = 0;
	// 增加一个对象锁
	private static Object o = new Object();

	public void run() {
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");
		
		for (int i = 0; i < 10; i++)
			try {
				addN();
				// sleep(3); // 为了使运行结果更随机，延迟3毫秒
			} catch (Exception e) {
			}
		
		System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end!");
	}

	private void addN() {
		// 每次只允许一个线程访问这个变量
		synchronized (o) {
			n++;
		}
	}

	public static void main(String[] args) throws Exception {
		Thread threads[] = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new ThreadExample();
		}
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		// if (args.length > 0) {
		for (int i = 0; i < threads.length; i++) {
			// 100个线程都执行完后继续
			threads[i].join();
		}
		// }
		System.out.println("n=" + ThreadExample.n);
	}
}
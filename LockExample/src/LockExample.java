import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

	public static void test1() throws Exception {
		final Lock lock = new ReentrantLock();
		lock.lock();
		Thread.sleep(1000);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				System.out.println(Thread.currentThread().getName() + "interrupted.");
			}
		});

		thread.start();
		Thread.sleep(1000);
		Thread.interrupted();
		Thread.sleep(1000);
	}

	public static void test2() throws Exception {
		final Lock lock = new ReentrantLock();
		lock.lock();
		Thread.sleep(1000);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					lock.lockInterruptibly();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(Thread.currentThread().getName() + " interrupted.");
				}
			}
		});

		thread.start();
		Thread.sleep(1000);
		Thread.interrupted();
		Thread.sleep(1000);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		test2();
	}

}

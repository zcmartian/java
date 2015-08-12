
public class MultiThreadHelloWorld {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread myThread = new Thread(){
			public void run(){
				System.out.println("Hello world from new thread !");
			}
		};
		myThread.start();
		//Thread.yield();
		Thread.sleep(1000);
		System.out.println("Hello from main thread");
		myThread.join();
	}

}

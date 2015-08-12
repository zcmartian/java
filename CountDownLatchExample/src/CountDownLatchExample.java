import java.util.concurrent.*;

public class CountDownLatchExample {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CountDownLatch latch = new CountDownLatch(3); 
		 
		Waiter      waiter      = new Waiter(latch); 
		Decrementer decrementer = new Decrementer(latch); 
		 
		new Thread(waiter)     .start(); 
		new Thread(decrementer).start(); 
		 
		Thread.sleep(4000); 
	}

}

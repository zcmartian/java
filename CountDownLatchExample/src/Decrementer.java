import java.util.concurrent.*;

public class Decrementer implements Runnable {

	CountDownLatch latch = null; 
	 
    public Decrementer(CountDownLatch latch) { 
        this.latch = latch; 
    }
    
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try { 
            Thread.sleep(1000); 
            this.latch.countDown(); 
 
            Thread.sleep(1000); 
            this.latch.countDown(); 
 
            Thread.sleep(1000); 
            this.latch.countDown(); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
	}

}

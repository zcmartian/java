import java.util.concurrent.CountDownLatch;

public class Waiter implements Runnable {

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println("Waiter run");
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }

}

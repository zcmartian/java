import java.util.Date;

/**
 * Created by marszhou on 16/1/2.
 */
public class VolatileServer {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                ;
            }
            System.out.println(System.currentTimeMillis());
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        System.out.println(System.currentTimeMillis());
        Thread.sleep(1000);
        number = 32;
        ready = true;
        Thread.sleep(10000);
    }
}

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mars on 2017/2/16.
 */
public class StopThread {
    private class Runner extends Thread {
        boolean bExit = false;

        public void exit(boolean bExit) {
            this.bExit = bExit;
        }

        @Override
        public void run() {
            while (!bExit) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StopThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Thread is stopped.");
        }
    }

    public static void main(String... args) throws InterruptedException {
        while (true) {
            Thread.sleep(10);
            System.out.println(System.nanoTime() + " Test loop begin.");
            StopThread stopThread = new StopThread();
            Runner r = stopThread.new Runner();
            r.start();
            r.exit(true);
            r.join();
            System.out.println(System.nanoTime() + " Test loop end.");
        }
    }
}

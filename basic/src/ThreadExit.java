/**
 * Created by mars on 2017/3/1.
 */
public class ThreadExit extends Thread {
    volatile boolean stop = false;

    public static void main(String args[]) throws Exception {
        ThreadExit thread = new ThreadExit();
        System.out.println("Starting thread...");
        thread.start();
        Thread.sleep(1000);
        thread.terminal();
//        System.out.println("Asking thread to stop...");
//        thread.stop = true;// 如果线程阻塞，将不会检查此变量
//        thread.interrupt();
//        Thread.sleep(3000);
        System.out.println("Stopping application...");
        // System.exit( 0 );
    }

    public void run() {
        while (!stop) {
            System.out.println("Thread running...");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted...");
            }
        }
        System.out.println("Thread exiting under request...");
    }

    public void terminal() {
        this.stop = true;
    }
}

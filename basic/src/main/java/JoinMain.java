/**
 * Created by marszhou on 16/1/1.
 */
public class JoinMain {
    public volatile static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        at.join();// print 10000000
        // at.join();// if not use join(), it will print 0
        System.out.print(i);
    }

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (; i < 10000000; ++i) ;
        }
    }
}

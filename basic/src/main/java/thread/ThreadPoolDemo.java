package thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;

public class ThreadPoolDemo {
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 1,
            TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
//            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 9; i++) {
                pool.execute(() -> System.out.println(currentThread().getName() + "\t 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            pool.shutdown();
        }
    }
}

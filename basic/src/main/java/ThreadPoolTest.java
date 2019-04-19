import java.util.concurrent.*;

public class ThreadPoolTest implements Runnable {
    public static void main(String[] args) {
        //BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(4);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue);
        for (int i = 0; i < 10; i++) {
            //executor.execute(new Thread(new ThreadPoolTest(), "TestThread".concat("" + i)));
            final int index = i;
            try {
                executor.execute(new Runnable() {
                    public void run() {
                        System.out.println(String.format("thread %d finished", index));
                    }
                });
            } catch (RejectedExecutionException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            //int threadSize = queue.size();
            //System.out.println("�̶߳��д�СΪ-->" + threadSize);
            System.out.println(executor.toString());
        }
        //System.out.println(executor.toString());
        executor.shutdown();
    }

    public void run() {
        synchronized (this) {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
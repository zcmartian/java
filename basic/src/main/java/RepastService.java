import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by mars on 2017/3/14.
 */
public class RepastService {

    private volatile Semaphore setSemaphore = new Semaphore(10);
    private volatile Semaphore getSemaphore = new Semaphore(20);
    private volatile ReentrantLock lock = new ReentrantLock();
    private volatile Condition setCondition = lock.newCondition();
    private volatile Condition getCondition = lock.newCondition();
    private volatile Object[] productionPosition = new Object[4];

    public boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < productionPosition.length; i++) {
            if (productionPosition[i] == null) {
                isFull = false;
                break;
            }
        }
        return isFull;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < productionPosition.length; i++) {
            if (productionPosition[i] != null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public void set() {
        try {
            setSemaphore.acquire();
            lock.lock();
            while (isFull()) {
                setCondition.await();
            }
            for (int i = 0; i < productionPosition.length; i++) {
                if (productionPosition[i] == null) {
                    productionPosition[i] = "数据";
                    System.out.println(Thread.currentThread().getName() + " 生产了 " + productionPosition[i]);
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            setSemaphore.release();
        }
    }

    public void get() {
        try {
            getSemaphore.acquire();
            lock.lock();
            while (isEmpty()) {
                getCondition.await();
            }
            for (int i = 0; i < productionPosition.length; i++) {
                if (productionPosition[i] != null) {
                    System.out.println(Thread.currentThread().getName() + " 消费了 " + productionPosition[i]);
                    productionPosition[i] = null;
                    break;
                }
            }
            getCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            getSemaphore.release();
        }

    }

    public static void main(String... args) throws InterruptedException {
        RepastService repastService = new RepastService();
        ThreadP[] arrayP = new ThreadP[60];
        ThreadC[] arrayC = new ThreadC[60];
        for (int i = 0; i < 60; i++) {
            arrayP[i] = new ThreadP(repastService);
            arrayC[i] = new ThreadC(repastService);
        }
        Thread.sleep(2000);
        for (int i = 0; i < 60; i++) {
            arrayP[i].start();
            arrayC[i].start();
        }
    }
}

class ThreadP extends Thread {
    private RepastService repastService;

    public ThreadP(RepastService repastService) {
        super();
        this.repastService = repastService;
    }

    public void run() {
        repastService.set();
    }

}

class ThreadC extends Thread {
    private RepastService repastService;

    public ThreadC(RepastService repastService) {
        super();
        this.repastService = repastService;
    }

    public void run() {
        repastService.get();
    }
}

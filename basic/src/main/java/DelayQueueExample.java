import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueExample {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        DelayQueue<Delayed> queue = new DelayQueue<Delayed>();

        Delayed element1 = new DelayedElement();
        // element1.getDelay(TimeUnit.SECONDS);
        queue.put(element1);
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " before take!");
        System.out.println(element1.getDelay(TimeUnit.SECONDS));
        Delayed element2 = queue.peek();
        if (element2 == null || element2.getDelay(TimeUnit.NANOSECONDS) > 0) {
            System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " await");
        }
        queue.poll();
        System.out.println(System.currentTimeMillis() + " " + Thread.currentThread().getName() + " after take!");
    }

}

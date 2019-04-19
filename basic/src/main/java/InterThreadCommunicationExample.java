import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mars on 2017/2/15.
 */
public class InterThreadCommunicationExample {


    public static void main(String args[]) {

        final Queue sharedQ = new LinkedList();

        Thread producer = new ProducerThread(sharedQ);
        Thread consumer = new Consumer(sharedQ, "Consumer-1");
        Thread consumer2 = new Consumer(sharedQ, "Consumer-2");

        producer.start();
        consumer.start();
        consumer2.start();

    }
}

class ProducerThread extends Thread {
    private static final int COUNT = 1000;
    private final Queue sharedQ;

    public ProducerThread(Queue sharedQ) {
        super("Producer-thread");
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {

        for (int i = 0; i < COUNT; i++) {
            synchronized (sharedQ) {
                // waiting condition - wait until Queue is not empty
                while (sharedQ.size() >= 10) {
                    try {
                        System.out.println(Thread.currentThread() + " Queue is full, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread() + "producing : " + i);
                sharedQ.add(i);
                sharedQ.notify();
            }
        }
    }
}

class Consumer extends Thread {
    private static final int COUNT = 1000;
    private final Queue sharedQ;
    private String threadName;

    public Consumer(Queue sharedQ, String threadName) {
        super(threadName);
        this.sharedQ = sharedQ;
    }

    @Override
    public void run() {
        while (true) {

            synchronized (sharedQ) {
                // waiting condition - wait until Queue is not empty
                while (sharedQ.size() == 0) {
                    try {
                        System.out.println(Thread.currentThread() + "Queue is empty, waiting");
                        sharedQ.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                int number = (Integer) sharedQ.poll();
                System.out.println(Thread.currentThread() + "consuming : " + number);
                sharedQ.notify();

                // termination condition
                if (number == COUNT - 1) {
                    break;
                }
            }
        }
    }
}

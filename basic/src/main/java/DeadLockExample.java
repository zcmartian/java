public class DeadLockExample {

    public static void main(String[] args) throws InterruptedException {
        final Object o1 = new Object();
        final Object o2 = new Object();

        Thread thread1 = new Thread(() -> {
            try {
                synchronized (o1) {
                    System.out.println("synchronized o1 enter");
                    Thread.sleep(1000);
                    synchronized (o2) {
                        System.out.println("synchronized o1 o2 enter");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                synchronized (o2) {
                    System.out.println("synchronized o2 enter");
                    Thread.sleep(1000);
                    synchronized (o1) {
                        System.out.println("synchronized o2 o1 enter");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        Thread.sleep(2000);
        thread1.interrupt();
        thread2.interrupt();
        thread1.join();
        thread2.join();
    }

}

package thread;

public class AlternateThreads2 {

    public static void main(String[] args) throws InterruptedException {
        Num num = new Num();
        long time1 = System.currentTimeMillis();
        Thread oddThread = new Thread(new PrintOddNum(num));
        Thread evenThread = new Thread(new PrintEvenNum(num));

        oddThread.start();
        evenThread.start();
        oddThread.join();
        evenThread.join();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }

    static class Num {
        int i = 1;
        boolean flag = false;
    }

    /**
     * 打印奇数的线程
     */
    static class PrintOddNum implements Runnable {
        Num num;

        public PrintOddNum(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num.i < 1000000) {
                synchronized (num) {
                    if (num.flag) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " -> " + num.i);
                        num.i++;
                        num.flag = true;
                        num.notify();
                    }
                }
            }
        }
    }

    /**
     * 打印奇数的线程
     */
    static class PrintEvenNum implements Runnable {
        Num num;

        public PrintEvenNum(Num num) {
            this.num = num;
        }

        @Override
        public void run() {
            while (num.i < 1000000) {
                synchronized (num) {
                    if (!num.flag) {
                        try {
                            num.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " -> " + num.i);
                        num.i++;
                        num.flag = false;
                        num.notify();
                    }
                }
            }
        }
    }

}

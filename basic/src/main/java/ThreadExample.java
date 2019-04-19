public class ThreadExample extends Thread {

    private static int n = 0;
    // ����һ��������
    private static Object o = new Object();

    public static void main(String[] args) throws Exception {
        Thread threads[] = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new ThreadExample();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        // if (args.length > 0) {
        for (int i = 0; i < threads.length; i++) {
            // 100���̶߳�ִ��������
            threads[i].join();
        }
        // }
        System.out.println("n=" + ThreadExample.n);
    }

    public void run() {
        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " start!");

        for (int i = 0; i < 10; i++)
            try {
                addN();
                // sleep(3); // Ϊ��ʹ���н����������ӳ�3����
            } catch (Exception e) {
            }

        System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " end!");
    }

    private void addN() {
        // ÿ��ֻ����һ���̷߳����������
        synchronized (o) {
            n++;
        }
    }
}
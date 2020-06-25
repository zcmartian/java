package thread;

import static java.lang.String.valueOf;
import static java.lang.Thread.currentThread;

public class SingletonDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(Singleton::getInstance, valueOf(i)).start();
        }
    }

    static class Singleton {
        private static volatile Singleton instance = null;

        public Singleton() {
            System.out.println(currentThread().getName() + "\t 构造方法");
        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
}
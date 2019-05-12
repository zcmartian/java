package com.mars.concurrency.second.concurrent.chapter1;

import com.mars.concurrency.annoations.ThreadSafe;

import java.util.stream.IntStream;

@ThreadSafe
public class SingletonObject7 {
    private SingletonObject7() {

    }

    public static SingletonObject7 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> new Thread(String.valueOf(i)) {
                    @Override
                    public void run() {
                        System.out.println(SingletonObject7.getInstance());
                    }
                }.start());
    }

    // 枚举的构造函数式私有的
    // 枚举的类是final 的
    private enum Singleton {
        INSTANCE;

        private final SingletonObject7 instance;

        Singleton() {
            instance = new SingletonObject7();
        }

        public SingletonObject7 getInstance() {
            return instance;
        }
    }
}

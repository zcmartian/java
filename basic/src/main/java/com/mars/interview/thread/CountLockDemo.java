package com.mars.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CountLockDemo {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Wrapper wrapper = new Wrapper(1);
        new Thread(new PrintOdd(lock, condition, wrapper)).start();
        new Thread(new PrintEven(lock, condition, wrapper)).start();
    }

    static class Wrapper {
        private Integer count;

        public Wrapper(Integer count) {
            this.count = count;
        }

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }
    }

    static class PrintOdd implements Runnable {
        private volatile Wrapper wrapper;
        private ReentrantLock lock;
        private Condition condition;

        public PrintOdd(ReentrantLock lock, Condition condition, Wrapper wrapper) {
            this.lock = lock;
            this.condition = condition;
            this.wrapper = wrapper;
        }

        @Override
        public void run() {
            while (wrapper.getCount() <= 100) {
                lock.lock();
                try {
                    if (wrapper.getCount() % 2 == 0) {
                        condition.await();
                    } else {
                        System.out.println("NumberValue thread print..." + wrapper.getCount());
                        wrapper.setCount(wrapper.getCount() + 1);
                        condition.signal();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class PrintEven implements Runnable {
        private volatile Wrapper wrapper;
        private ReentrantLock lock;
        private Condition condition;

        public PrintEven(ReentrantLock lock, Condition condition, Wrapper wrapper) {
            this.lock = lock;
            this.condition = condition;
            this.wrapper = wrapper;
        }

        @Override
        public void run() {
            while (wrapper.getCount() <= 100) {
                lock.lock();
                try {
                    if (wrapper.getCount() % 2 == 1) {
                        condition.await();
                    } else {
                        System.out.println("StringValue thread print..." + wrapper.getCount());
                        wrapper.setCount(wrapper.getCount() + 1);
                        condition.signal();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

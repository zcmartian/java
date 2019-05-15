package com.mars.interview.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CountLockDemo2 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Wrapper wrapper = new Wrapper(0);
        new Thread(new PrintOdd(lock, condition, wrapper)).start();
        new Thread(new PrintEven(lock, condition, wrapper)).start();
    }

    static class Wrapper {
        private volatile int count;

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
        private Wrapper wrapper;
        private ReentrantLock lock;
        private Condition condition;
        private int[] values = {1,2,3};

        public PrintOdd(ReentrantLock lock, Condition condition, Wrapper wrapper) {
            this.lock = lock;
            this.condition = condition;
            this.wrapper = wrapper;
        }

        @Override
        public void run() {
            while (wrapper.getCount() < 6) {
                lock.lock();
                try {
                    if (wrapper.getCount() % 2 == 0) {
                        condition.await();
                    } else {
                        System.out.println(values[wrapper.getCount()/2]);
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
        private Wrapper wrapper;
        private ReentrantLock lock;
        private Condition condition;
        private char[] values = {'a', 'b', 'c'};

        public PrintEven(ReentrantLock lock, Condition condition, Wrapper wrapper) {
            this.lock = lock;
            this.condition = condition;
            this.wrapper = wrapper;
        }

        @Override
        public void run() {
            while (wrapper.getCount() < 6) {
                lock.lock();
                try {
                    if (wrapper.getCount() % 2 == 1) {
                        condition.await();
                    } else {
                        System.out.println(values[wrapper.getCount()/2]);
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

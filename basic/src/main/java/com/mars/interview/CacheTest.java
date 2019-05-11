package com.mars.interview;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    private static final int CONCURRENT_NUM = 10;

    private volatile static int value = 1;

    private static long accessTime;

    private static LoadingCache<String, String> cache = CacheBuilder
            .newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .refreshAfterWrite(1, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws InterruptedException {
                    System.out.println("load by " + Thread.currentThread().getName() + " at " + accessTime);
                    return createValue();
                }

                @Override
                public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                    System.out.println("reload by " + Thread.currentThread().getName() + " after " + (System.currentTimeMillis() - accessTime) + " ms.");
                    return Futures.immediateFuture(createValue());
                }
            });

    // 创建value
    private static String createValue() throws InterruptedException {
        // 让当前线程sleep 随机时间，是为了测试load和reload时候的并发特性
        // 即,即便触发了刷新操作,但是刷新操作本身需要一些耗时,同时进来的读请求仍然拿到了旧值
        Thread.sleep((long) (Math.random() * 3000));
        accessTime = System.currentTimeMillis();
        System.out.println("reload complete.");
        return String.valueOf(value++);
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CyclicBarrier barrier = new CyclicBarrier(CONCURRENT_NUM);
        CountDownLatch latch = new CountDownLatch(CONCURRENT_NUM);
        for (int i = 0; i < CONCURRENT_NUM; i++) {
            final ClientRunnable runnable = new ClientRunnable(barrier, latch);
            Thread thread = new Thread(runnable, "client-" + i);
            thread.start();
        }

        // 测试一段时间不访问后是否执行expire而不是refresh
        latch.await();
        Thread.sleep(5100L);
        System.out.println("\n超过expire时间未读之后...");
        System.out.println(Thread.currentThread().getName() + ",val:" + cache.get("key"));
    }

    static class ClientRunnable implements Runnable {

        CyclicBarrier barrier;
        CountDownLatch latch;

        public ClientRunnable(CyclicBarrier barrier, CountDownLatch latch) {
            this.barrier = barrier;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                barrier.await();
                // 每个client随机睡眠，为了充分测试refresh和load
                Thread.sleep((long) (Math.random() * 4000));
                System.out.println(Thread.currentThread().getName() + ",val:" + cache.get("key"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }

    }

}

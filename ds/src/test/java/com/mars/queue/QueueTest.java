package com.mars.queue;

import com.mars.list.LinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.util.Random;
import java.util.TreeMap;

public class QueueTest {

    @Rule
    public final SystemOutRule log = new SystemOutRule().enableLog();
    ArrayQueue<Integer> arrayQueue;
    LoopQueue<Integer> loopQueue;
    LinkedListQueue<Integer> linkedListQueue;

    @Before
    public void init() {
        arrayQueue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
        }
        Assert.assertEquals("Queue: front [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] tail", arrayQueue.toString());
        loopQueue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
        }
        Assert.assertEquals("Queue: size=10, capacity=10\n" +
                "front [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] tail", loopQueue.toString());
        linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
        }
        Assert.assertEquals("Queue: size=10, capacity=10\n" +
                "front [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] tail", loopQueue.toString());
    }

    @Test
    public void testArrayQueue() {
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 2) {
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }
        Assert.assertEquals("Queue: front [1, 2, 3, 4, 5, 6, 7, 8, 9] tail\n" +
                "Queue: front [2, 3, 4, 5, 6, 7, 8, 9] tail\n" +
                "Queue: front [3, 4, 5, 6, 7, 8, 9] tail\n", log.getLog());
    }

    @Test
    public void testLoopQueue() {
        for (int i = 0; i < 30; i++) {
            if (i % 3 == 2) {
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
        Assert.assertEquals("Queue: size=9, capacity=10\n" +
                "front [1, 2, 3, 4, 5, 6, 7, 8, 9] tail\n" +
                "Queue: size=8, capacity=10\n" +
                "front [2, 3, 4, 5, 6, 7, 8, 9] tail\n" +
                "Queue: size=7, capacity=10\n" +
                "front [3, 4, 5, 6, 7, 8, 9] tail\n" +
                "Queue: size=6, capacity=10\n" +
                "front [4, 5, 6, 7, 8, 9] tail\n" +
                "Queue: size=5, capacity=10\n" +
                "front [5, 6, 7, 8, 9] tail\n" +
                "Queue: size=4, capacity=10\n" +
                "front [6, 7, 8, 9] tail\n" +
                "Queue: size=3, capacity=10\n" +
                "front [7, 8, 9] tail\n" +
                "Queue: size=2, capacity=5\n" +
                "front [8, 9] tail\n" +
                "Queue: size=1, capacity=2\n" +
                "front [9] tail\n" +
                "Queue: size=0, capacity=1\n" +
                "front [] tail\n", log.getLog());
    }

    private double testQueue(Queue<Integer> queue, int optCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < optCount; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < optCount; i++)
            queue.dequeue();

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void testPerformance() {
        int optCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, optCount);
        System.out.println("ArrayQueue, time: " + time1 + " s.");
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, optCount);
        System.out.println("LoopQueue, time: " + time2 + " s.");
        double time3 = testQueue(linkedListQueue, optCount);
        System.out.println("LinkedListQueue, time: " + time3 + " s.");
        System.out.println(time1/time3);
    }

    @Test
    public void testTopK() {
        class Freq implements Comparable<Freq> {
            int e, freq;
            public Freq(int e, int freq) {
                this.e = e;
                this.freq = freq;
            }

            @Override
            public String toString() {
                return e + " : " + freq;
            }
            @Override
            public int compareTo(Freq o) {
                if (this.freq < o.freq) {
                    return 1;
                } else if (this.freq > o.freq) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
        int n = 1000000;
        int k = 100;
        int[] nums = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            nums[i] = random.nextInt(300) + random.nextInt(10);
        }
        TreeMap<Integer, Integer> map = new TreeMap();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key: map.keySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(key, map.get(key)));
            } else if (map.get(key) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Freq> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue());
        }

        for (int i = 1; i < res.getSize(); i++) {
            System.out.println(res.get(i));
            if (res.get(i - 1).freq > res.get(i).freq) {
                throw new IllegalArgumentException("Error");
            }
        }
    }
}

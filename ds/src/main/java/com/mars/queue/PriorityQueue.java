package com.mars.queue;

import com.mars.heap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }
    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }
}

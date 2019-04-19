package com.mars.queue;

import com.mars.array.Array;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;


    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E getFront() {
        return array.get(0);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }
}

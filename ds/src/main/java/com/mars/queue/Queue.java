package com.mars.queue;

public interface Queue<E> {

    boolean isEmpty();
    E dequeue();
    void enqueue(E e);
    E getFront();
    int getSize();
}

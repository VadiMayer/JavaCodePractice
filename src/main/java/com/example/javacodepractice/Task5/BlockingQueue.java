package com.example.javacodepractice.Task5;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueue<E> {

    private LinkedList<E> storage;

    private final int size;

    private AtomicInteger currentSize;

    public BlockingQueue(int size) {
        this.size = size;
        storage = new LinkedList<>();
    }

    //enqueue() для добавления элемента в очередь
    boolean enqueue(E e) throws InterruptedException {
        if (currentSize.get() == size) {
            Thread.currentThread().wait();
            return false;
        }
        storage.add(currentSize.get(), e);
        currentSize.incrementAndGet();
        return true;
    }

    // dequeue() для извлечения элемента
    // Если очередь пуста, dequeue() должен блокировать вызывающий поток до появления нового элемента.
    E dequeue() throws InterruptedException {
        if (currentSize.get() == 0) {
            Thread.currentThread().wait();
            return null;
        } else
            return storage.pollFirst();
    }

    public int size() {
        return currentSize.get();
    }
}

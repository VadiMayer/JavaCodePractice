package com.example.javacodepractice.Task5;

import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueue<E> {

    private E[] storage;
    private int head;
    private int tail;

    private final int size;

    private AtomicInteger currentSize;

    private final Object lock;

    public BlockingQueue(int size) {
        this.size = size;
        currentSize = new AtomicInteger(0);
        storage = (E[]) new Object[size];
        lock = new Object();
        head = 0;
        tail = 0;
    }

    //enqueue() для добавления элемента в очередь
    public void enqueue(E e) throws InterruptedException {
        synchronized (lock) {
            while (currentSize.get() == size) {
                lock.wait();
            }
            storage[tail] = e;
            tail = (tail + 1) % size;
            currentSize.incrementAndGet();
            lock.notify();
        }
    }

    // dequeue() для извлечения элемента
    // Если очередь пуста, dequeue() должен блокировать вызывающий поток до появления нового элемента.
    public E dequeue() throws InterruptedException {
        synchronized (lock) {
            while (currentSize.get() == 0) {
                lock.wait();
            }
            E element = storage[head];
            head = (head + 1) % size;
            currentSize.decrementAndGet();
            lock.notify();
            return element;
        }
    }

    public int size() {
        return currentSize.get();
    }
}

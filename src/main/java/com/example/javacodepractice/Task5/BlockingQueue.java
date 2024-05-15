package com.example.javacodepractice.Task5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueue<E> {

    private Queue<E> storage;

    private final int size;

    private AtomicInteger currentSize;

    private final Object lock;

    public BlockingQueue(int size) {
        this.size = size;
        currentSize = new AtomicInteger(0);
        storage = new LinkedList<>();
        lock = new Object();
    }

    //enqueue() для добавления элемента в очередь
    public void enqueue(E e) throws InterruptedException {
        synchronized (lock) {
            while (currentSize.get() == size) {
                lock.wait();
            }
            storage.add(e);
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
            E firstElement = storage.remove();
            currentSize.decrementAndGet();
            lock.notify();
            return firstElement;
        }
    }

    public int size() {
        return currentSize.get();
    }

    public void getElements() {
        System.out.println(storage);
    }
}

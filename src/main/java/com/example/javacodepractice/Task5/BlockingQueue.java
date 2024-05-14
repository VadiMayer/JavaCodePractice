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
        storage = new LinkedList<>();
        lock = new Object();
    }

    //enqueue() для добавления элемента в очередь
    public boolean enqueue(E e) throws InterruptedException {
        synchronized (lock) {
            if (currentSize.get() == size) {
                lock.wait();
                return false;
            } else {
                storage.add(e);
                currentSize.incrementAndGet();
                lock.notify();
                return true;
            }
        }
    }

    // dequeue() для извлечения элемента
    // Если очередь пуста, dequeue() должен блокировать вызывающий поток до появления нового элемента.
    public E dequeue() throws InterruptedException {
        synchronized (lock) {
            if (currentSize.get() == 0) {
                lock.wait();
                return null;
            } else {
                E firstElement = storage.remove();
                lock.notify();
                return firstElement;
            }
        }
    }

    public int size() {
        return currentSize.get();
    }

    public void getElements() {
        System.out.println(storage);
    }
}

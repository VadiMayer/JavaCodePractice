package com.example.javacodepractice.Task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockingQueueTest {

    @Test
    void enqueue() throws InterruptedException {
        BlockingQueue<Integer> queue = new BlockingQueue<>(5);

        // Создаем поток для добавления элементов в очередь
        Thread producerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    queue.enqueue(i);
                    System.out.println("Enqueued: " + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Создаем поток для извлечения элементов из очереди
        Thread consumerThread = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    Integer value = queue.dequeue();
                    System.out.println("Dequeued: " + value);
                    if (value == null) {
                        i--;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();

        // Ждем, пока оба потока завершатся
        producerThread.join();
        consumerThread.join();

        // Проверяем, что очередь пуста после завершения теста
        assertEquals(0, queue.size());
    }

    @Test
    void dequeue() {
    }
}
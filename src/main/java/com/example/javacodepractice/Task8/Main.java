package com.example.javacodepractice.Task8;

import java.util.concurrent.BrokenBarrierException;

public class Main {
    public static void main(String[] args) {
        ComplexTaskExecutor complexTaskExecutor = new ComplexTaskExecutor(1);

        Runnable testRunnable = () -> {
            System.out.println(Thread.currentThread().getName() + " started the test.");

            // Выполнение задач
            try {
                complexTaskExecutor.executeTasks(1);
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " completed the test.");
        };

        Thread thread1 = new Thread(testRunnable, "TestThread-1");
        Thread thread2 = new Thread(testRunnable, "TestThread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

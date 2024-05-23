package com.example.javacodepractice.MonitorCaptureTest;

public class MonitorCaptureTest {
    static int vClass = 0;

    int object = 0;

    static synchronized void incrementClass() {
        try {
            System.out.println("Dive into incrementClass " + Thread.currentThread().getName());
            Thread.sleep(3000);
            vClass++;
            System.out.println("Class " + vClass);
        } catch (InterruptedException e) {}
    }

    synchronized void incrementObject() {
        try {
            System.out.println("Dive into incrementObject " + Thread.currentThread().getName());
            Thread.sleep(3000);
            object++;
            System.out.println("Object " + object);
        } catch (InterruptedException e) {}
    }
}

class Main {
    public static void main(String[] args) {

        MonitorCaptureTest test = new MonitorCaptureTest();

        Thread thread1 = new Thread(()-> {
            MonitorCaptureTest.incrementClass();
            System.out.println("вышли из потока класса " + Thread.currentThread().getName());
        });

        Thread thread2 = new Thread(()-> {
            MonitorCaptureTest.incrementClass();
            System.out.println("вышли из потока класса " + Thread.currentThread().getName());
        });

        Thread thread3 = new Thread(()-> {
            test.incrementObject();
            System.out.println("вышли из потока объекта " + Thread.currentThread().getName());
        });

        Thread thread4 = new Thread(()-> {
            test.incrementObject();
            System.out.println("вышли из потока объекта " + Thread.currentThread().getName());
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }
}

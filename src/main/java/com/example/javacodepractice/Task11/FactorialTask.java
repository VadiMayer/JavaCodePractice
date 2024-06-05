package com.example.javacodepractice.Task11;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Integer> {

    private int from = 1;

    private int to;

    public FactorialTask(int factorialN) {
        this.to = factorialN;
    }

    private FactorialTask(int to, int from) {
        this.to = to;
        this.from = from;
    }

    @Override
    protected Integer compute() {
        if (to - from <= 1) {
            int result = 1;
            for (int i = from; i <= to; i++) {
                result = result * i;
            }
            return result;
        } else {
            int mid = (to + from) / 2;
            RecursiveTask<Integer> firstHalf = new FactorialTask(to, mid);
            firstHalf.fork();
            RecursiveTask<Integer> secondHalf = new FactorialTask(mid, to);
            secondHalf.fork();
            return firstHalf.join() + secondHalf.join();
        }
    }
}

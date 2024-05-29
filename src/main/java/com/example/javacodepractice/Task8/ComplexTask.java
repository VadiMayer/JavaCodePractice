package com.example.javacodepractice.Task8;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;

public class ComplexTask implements Callable<Integer> {
    private final List<Integer> data;

    private final CyclicBarrier cyclicBarrier;

    public ComplexTask(List<Integer> data, CyclicBarrier cyclicBarrier) {
        this.data = data;
        this.cyclicBarrier = new CyclicBarrier(cyclicBarrier.getParties());
    }

    public int execute() {
        return data.stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public Integer call() throws Exception {
        Integer result = execute();
        cyclicBarrier.await();
        return result;
    }
}

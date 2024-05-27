package com.example.javacodepractice.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final ExecutorService[] executorService;
    private final List<ComplexTask> storage;
    private final int numberOfTasks;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.executorService = new ExecutorService[numberOfTasks];
        this.numberOfTasks = numberOfTasks;
        storage = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++) {
            storage.add(new ComplexTask(List.of(1, 1, 1, 1, 1)));
        }
    }

    public void executeTasks(int runSeveralTimes) throws BrokenBarrierException, InterruptedException {

        List<Callable<ComplexTask>> tasks = new ArrayList<>();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            for (int j = 0; j < runSeveralTimes; j++) {
                int forLambda = j;
                tasks.add(() -> storage.get(forLambda));
            }
            executorService[i] = Executors.newFixedThreadPool(runSeveralTimes);
            List<Future<ComplexTask>> listFuture = executorService[i].invokeAll(tasks);
            for (Future<ComplexTask> future : listFuture) {
                try {
                    future.get().execute();
                    cyclicBarrier.await();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
            tasks.clear();
        }
    }
}

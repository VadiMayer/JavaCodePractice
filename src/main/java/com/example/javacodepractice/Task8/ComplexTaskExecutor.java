package com.example.javacodepractice.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final ExecutorService executorService;
    private CyclicBarrier cyclicBarrier;
    private final List<ComplexTask> storage;
    private final int numberOfTasks;

    public ComplexTaskExecutor(int numberOfTasks) {
        executorService = Executors.newFixedThreadPool(numberOfTasks);
        this.numberOfTasks = numberOfTasks;
        storage = new ArrayList<>();
    }

    public boolean add(ComplexTask complexTask) {
        return storage.add(complexTask);
    }

    public void executeTasks() throws BrokenBarrierException, InterruptedException {
        List<Callable<ComplexTask>> tasks = new ArrayList<>();

        cyclicBarrier = new CyclicBarrier(numberOfTasks, );

        for (int i = 0; i < numberOfTasks; i++) {
            final int f = i;
            tasks.add(() -> storage.get(f));
        }

        List<Future<ComplexTask>> listFuture = executorService.invokeAll(tasks);

        for (Future<ComplexTask> future : listFuture) {
            try {
                future.get().execute();
                cyclicBarrier.await();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public void sum() {
        int result = 0;
        for (int i = 0; i < storage.size(); i++) {
            result = result + resultTask;
        }
    }
}

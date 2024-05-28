package com.example.javacodepractice.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final ExecutorService[] executorService;
    private final List<ComplexTask> storage;
    private final int numberOfTasks;
    private final CyclicBarrier cyclicBarrier;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.executorService = new ExecutorService[numberOfTasks];
        this.numberOfTasks = numberOfTasks;
        this.cyclicBarrier = new CyclicBarrier(numberOfTasks);
        storage = new ArrayList<>();
        for (int i = 0; i < numberOfTasks; i++) {
            storage.add(new ComplexTask(List.of(1, 1, 1, 1, 1), cyclicBarrier));
        }
    }

    public void executeTasks(int runSeveralTimes) throws BrokenBarrierException, InterruptedException {

        List<Callable<ComplexTask>> tasks = new ArrayList<>();

        for (int i = 0; i < numberOfTasks; i++) {
            //размножаем задачу на runSeveralTimes записываем в tasks
            for (int j = 0; j < runSeveralTimes; j++) {
                int forLambda = i;
                tasks.add(() -> storage.get(forLambda));
            }
            //создаем для каждого комплекта задач executorService
            executorService[i] = Executors.newFixedThreadPool(runSeveralTimes);
            List<Future<ComplexTask>> listFuture = executorService[i].invokeAll(tasks);
            int result = 0;
            for (Future<ComplexTask> future : listFuture) {
                try {
                    result = result + future.get().call();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(result);
            tasks.clear();
        }
    }
}

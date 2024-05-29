package com.example.javacodepractice.Task8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ComplexTaskExecutor {
    private final ExecutorService[] executorService;
    private final List<ComplexTask> storage;
    private final int numberOfTasks;
    private CyclicBarrier cyclicBarrier;

    public ComplexTaskExecutor(int numberOfTasks) {
        this.executorService = new ExecutorService[numberOfTasks];
        this.numberOfTasks = numberOfTasks;
        storage = new ArrayList<>();
    }

    public synchronized void executeTasks(int runSeveralTimes) throws BrokenBarrierException, InterruptedException {

        List<Callable<Integer>> tasks = new ArrayList<>();
        cyclicBarrier = new CyclicBarrier(runSeveralTimes);

        for (int i = 0; i < numberOfTasks; i++) {
            storage.add(new ComplexTask(List.of(1, 1, 1, 1, 1), cyclicBarrier));
        }

        for (int i = 0; i < numberOfTasks; i++) {
            //размножаем задачу на runSeveralTimes записываем в tasks
            for (int j = 0; j < runSeveralTimes; j++) {
                Callable<Integer> taskForExecution = storage.get(i);
                tasks.add(taskForExecution);
            }
            //создаем для каждого комплекта задач executorService
            executorService[i] = Executors.newFixedThreadPool(runSeveralTimes);
            List<Future<Integer>> listFuture = executorService[i].invokeAll(tasks);
            int result = 0;
            for (Future<Integer> future : listFuture) {
                try {
                    result = result + future.get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(result);
            tasks.clear();
            Thread.sleep(500);
            executorService[i].shutdown();
        }
    }
}

package thread;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(10);
        es.execute(() -> System.out.println("Asynchronous task 1"));

        // execute(Runnable)
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        executorService.execute(() -> System.out.println("Asynchronous task 2"));

        // submit(Runnable)
        Future future1 = executorService.submit(() -> System.out.println("Asynchronous task 3"));

        System.out.println(future1.get()); // returns null if the task has finished correctly.

        // submit(Callable)
        Future future2 = executorService.submit((Callable) () -> {
            System.out.println("Asynchronous Callable");
            return "Callable Result";
        });

        System.out.println("future.get() = " + future2.get());

        // invokeAny()
        Set<Callable<String>> callables = new HashSet<Callable<String>>();

        callables.add(() -> "Task 1");
        callables.add(() -> "Task 2");
        callables.add(() -> "Task 3");

        String result = executorService.invokeAny(callables);

        System.out.println("result = " + result);

        //invokeAll()
        List<Future<String>> futures = executorService.invokeAll(callables);

        for (Future<String> future : futures) {
            System.out.println("future.get = " + future.get());
        }

        es.shutdown();
        executorService.shutdown();
    }

}

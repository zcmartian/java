import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorServiceExample {

	public static void main(String[] args) throws Exception, ExecutionException {
		// TODO Auto-generated method stub
		ExecutorService es = Executors.newFixedThreadPool(10);
		es.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task 1");
			}
		});

		// execute(Runnable)
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.execute(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task 2");
			}
		});
		// executorService.shutdown();

		// submit(Runnable)
		Future future1 = executorService.submit(new Runnable() {
			public void run() {
				System.out.println("Asynchronous task 3");
			}
		});

		System.out.println(future1.get()); // returns null if the task has finished correctly.
		// executorService.shutdown();

		// submit(Callable)
		Future future2 = executorService.submit(new Callable() {
			public Object call() throws Exception {
				System.out.println("Asynchronous Callable");
				return "Callable Result";
			}
		});

		System.out.println("future.get() = " + future2.get());

		// invokeAny()
		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 1";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 2";
			}
		});
		callables.add(new Callable<String>() {
			public String call() throws Exception {
				return "Task 3";
			}
		});

		String result = executorService.invokeAny(callables);

		System.out.println("result = " + result);
		
		//invokeAll()
		List<Future<String>> futures = executorService.invokeAll(callables); 
		 
		for(Future<String> future : futures){ 
		    System.out.println("future.get = " + future.get()); 
		} 
	}

}

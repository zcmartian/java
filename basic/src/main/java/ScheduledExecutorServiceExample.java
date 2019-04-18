import java.util.concurrent.*;

public class ScheduledExecutorServiceExample {

    public static void main(String[] args) throws Exception, ExecutionException {
        // TODO Auto-generated method stub
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        ScheduledFuture scheduledFuture = scheduledExecutorService.schedule(new Callable() {
            public Object call() throws Exception {
                System.out.println("Executed!");
                return "Called!";
            }
        }, 5, TimeUnit.SECONDS);

        System.out.println("result = " + scheduledFuture.get());
    }

}

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Java8Demo {
    @FunctionalInterface
    interface UserFactory<U extends UserData> {
        U create(int i, String name);
    }
    static UserFactory<UserData> uf = UserData::new;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<UserData> users = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            users.add(uf.create(i, "billy" + Integer.toString(i)));
        }
        users.stream().map(UserData::getName).forEach(System.out::println);

        Arrays.stream(arr).forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                System.out.println(value);
            }
        });

        Arrays.stream(arr).forEach((x) -> {
            System.out.println(x);
        });

        Arrays.stream(arr).forEach((x) -> System.out.println(x));

        class AskThread implements Runnable {
            CompletableFuture<Integer> re = null;

            public AskThread(CompletableFuture<Integer> re) {
                this.re = re;
            }

            public void run() {
                int myRe = 0;
                try {
                    myRe = re.get() * re.get();
                } catch (Exception e) {

                }
                System.out.println(myRe);
            }
        }

        final CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(new AskThread(future)).start();
        Thread.sleep(1000);
        future.complete(60);

        CompletableFuture<Void> fu = CompletableFuture.supplyAsync(() -> calc(50))
                .thenApply((i) -> Integer.toString(i))
                .thenApply((str) -> "\"" + str + "\"")
                .thenAccept(System.out::println);
        fu.get();
    }

    static int[] arr = {1,2,3,4,5,6,7,8,9};

    public static Integer calc(Integer para) {
        try { SECONDS.sleep(1);} catch (InterruptedException e) { e.printStackTrace();}
        return para * para;
    }
}

@Data
@AllArgsConstructor
class UserData {
    private int id;
    private String name;
}

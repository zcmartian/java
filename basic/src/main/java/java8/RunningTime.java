package java8;

import java.util.function.Consumer;

public class RunningTime {
    public static void calculate(Consumer<Void> consumer) {
        long startTime = System.nanoTime();
        consumer.accept(null);
        long endTime = System.nanoTime();
        System.out.println(consumer.toString() + " execution time: " + (double)(endTime - startTime) / 1000_000 + " ms.");
    }
}

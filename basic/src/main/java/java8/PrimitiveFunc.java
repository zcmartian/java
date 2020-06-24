package java8;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class PrimitiveFunc {

    public static void main(String[] args) {
        int[] arr = IntStream.range(1, 50000).toArray();
        BinaryOperator<Integer> f1 = Integer::sum;
        IntBinaryOperator f2 = (i, j) -> i + j;

        // RunningTime is an utility class to calculate execution time
        RunningTime.calculate((Consumer<Void>) v -> reduceWrapper(arr, f1));
        RunningTime.calculate((Consumer<Void>) v -> reducePrimitive(arr, f2));
    }

    static int reduceWrapper(int[] arr, BinaryOperator<Integer> operator) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = operator.apply(result, arr[i]);  // Boxing and Unboxing here
        }
        return result;
    }

    static int reducePrimitive(int[] arr, IntBinaryOperator operator) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = operator.applyAsInt(result, arr[i]);
        }
        return result;
    }
}

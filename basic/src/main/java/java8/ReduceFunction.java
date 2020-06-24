package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceFunction {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("This is stream reduction example learn well".split(" "));
        int result = words.stream().map(String::length).reduce(0, Integer::sum);
        System.out.println(result);
        Optional<Integer> opt = words.stream().map(String::length).reduce(Integer::sum);
        opt.ifPresent(System.out::println);
        result = words.stream().reduce(0, (i, str) -> i + str.length(), Integer::sum);
        System.out.println(result);

        reduceThreeArgs(words);
    }

    public static void reduceThreeArgs(List<String> words) {
        int result = words.parallelStream().reduce(0, (p, str) -> {
            System.out.println("BiFunc: " + p + "  " + str);
            return p + str.length();
        }, (i, j) -> {
            System.out.println("BiOpr: " + i + "  " + j);
            return i + j;
        });
    }
}

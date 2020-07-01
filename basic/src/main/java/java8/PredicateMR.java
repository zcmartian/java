package java8;

import java.util.function.Predicate;

public class PredicateMR {
    public static boolean myTest(Integer x) {
        return (x > 7) ? true : false;
    }

    public static boolean myTest(String s) {
        return (s.charAt(0) == 'H') ? true : false;
    }

    public static void result(Predicate<Integer> p, Integer arg) {
        if (p.test(arg))
            System.out.println("The Predicate is true for " + arg);
        else
            System.out.println("The Predicate is false for " + arg);
    }

    public static void result(Predicate<String> p, String arg) {
        if (p.test(arg))
            System.out.println("The Predicate is true for " + arg);
        else
            System.out.println("The Predicate is false for " + arg);
    }

    public static void main(String[] args) {
        Predicate<Integer> p1 = x -> x > 7;
        if (p1.test(9))
            System.out.println("Predicate x > 7 is true for x==9.");
        Predicate<Integer> p2 = PredicateMR::myTest;
        if (p2.test(9))
            System.out.println("Predicate x > 7 is true " + "for x==9.");

        result(PredicateMR::myTest, 5);
        result(PredicateMR::myTest, "Hello");
    }
}
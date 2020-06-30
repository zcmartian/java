package java8;

import java.util.function.Predicate;

public class PredicateMR {
    public static boolean myTest(Integer x) {
        return (x > 7) ? true : false;
    }

    public static void main(String[] args) {
        Predicate<Integer> p1 = x -> x > 7;
        if (p1.test(9))
            System.out.println("Predicate x > 7 is true for x==9.");
        Predicate<Integer> p2 = PredicateMR::myTest;
        if (p2.test(9))
            System.out.println("Predicate x > 7 is true " + "for x==9.");
    }
}
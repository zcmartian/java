package java8;

import java.util.function.Predicate;

class P1 {
    public boolean greaterThan7(Integer x) {
        return (x > 7) ? true : false;
    }
}

class P2 {
    public boolean isOdd(Integer x) {
        return (x % 2 == 1) ? true : false;
    }
}

class TestInstanceReference {
    public static void main(String[] args) {
        P1 p1 = new P1();
        P2 p2 = new P2();
        Predicate<Integer> pred1 = p1::greaterThan7;
        Predicate<Integer> pred2 = p2::isOdd;
        System.out.println(pred1.test(8));
        System.out.println(pred2.test(8));
    }
}

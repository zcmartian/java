package java8.functional;

public interface I2 {
    String s = "I2";
    static void method1() {
        System.out.println(s);
    }

    default String method2(String x) {
        return s + x;
    }
}

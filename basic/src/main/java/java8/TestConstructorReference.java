package java8;

import java.util.function.Supplier;

class X {
    static int count = 0;

    public X() {
        count++;
    }

    @Override
    public String toString() {
        return "" + count;
    }
}
public class TestConstructorReference {
    public static void main(String[] args) {
        Supplier<X> getX = X::new;
        X x = null;
        for (int i = 0; i < 10; i++) {
            x = getX.get();
        }
        System.out.println(x);
    }
}

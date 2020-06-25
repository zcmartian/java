package thread;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User z3 = new User("zhangsan", 25);
        User l4 = new User("lisi", 24);

        AtomicReference<User> atomicReference = new AtomicReference<>(z3);
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, l4) + "\t" + atomicReference.get().toString());
    }


    @Data
    @AllArgsConstructor
    static class User {
        private String name;
        private int age;
    }
}


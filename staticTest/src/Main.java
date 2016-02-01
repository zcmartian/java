public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Person {
    static {
        System.out.println("person static");
    }

    public Person(String str) {
        System.out.println("person " + str);
    }
}

class MyClass extends Test {
    static {
        System.out.println("myclass static");
    }

    Person person = new Person("MyClass");

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

class StaticTest {
    static {
        System.out.println("Unused static block");
    }
}

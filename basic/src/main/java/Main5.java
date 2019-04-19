public class Main5 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}

class Person2 {
    static {
        System.out.println("person static");
    }

    public Person2(String str) {
        System.out.println("person " + str);
    }
}

class MyClass extends Test {
    static {
        System.out.println("myclass static");
    }

    Person2 person = new Person2("MyClass");

    public MyClass() {
        System.out.println("myclass constructor");
    }
}

class StaticTest {
    static {
        System.out.println("Unused static block");
    }
}

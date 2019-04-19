public class Test2 {
    static {
        System.out.println("test static");
    }

    Person2 person = new Person2("Test");

    public Test2() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
//        new StaticTest();
    }
}

public class Test {
    static {
        System.out.println("test static");
    }

    Person person = new Person("Test");

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();
//        new StaticTest();
    }
}

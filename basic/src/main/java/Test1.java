/**
 * Created by mars on 2017/1/18.
 */
class Singleton {

    private static Singleton mInstance = new Singleton();// 位置1
    // 位置1输出：
    // counter1: 1
    // counter2: 0
    public static int counter1;
    public static int counter2 = 0;

//    private static Singleton mInstance = new Singleton();// 位置2

    // 位置2输出：
    // counter1: 1
    // counter2: 1

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstantce() {
        return mInstance;
    }
}

public class Test1 {

    public static void main(String[] args) {

        Singleton singleton = Singleton.getInstantce();
        System.out.println("counter1: " + Singleton.counter1);
        System.out.println("counter2: " + Singleton.counter2);
    }
}

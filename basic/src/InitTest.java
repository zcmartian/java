import java.util.Random;

/**
 * Created by mars on 2017/1/18.
 */
class FinalTest1 {
    public static final int x = 6 / 3; // 编译时期已经可知其值为2，是常量
    // 类型不需要进行初始化
    static {
        System.out.println("static block in FinalTest1");
        // 此段语句不会被执行，即无输出
    }
}

class FinalTest2 {
    public static final int x = new Random().nextInt(100);// 只有运行时才能得到值
    static {
        System.out.println("static block in FinalTest2");
        // 会进行类的初始化，即静态语句块会执行，有输出
    }
}

public class InitTest {

    public static void main(String[] args) {
        System.out.println("FinalTest1: " + FinalTest1.x);
        System.out.println("FinalTest2: " + FinalTest2.x);
    }
}

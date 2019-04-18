/**
 * Created by Administrator on 2017/2/22.
 */
public class SelfSynchronize {
    public static void main(String... args) {
        SelfSynchronize self = new SelfSynchronize();
        self.methodA();
    }

    public synchronized void methodA() {
        System.out.println("pring methodA");
        methodB();
    }

    public synchronized void methodB() {
        System.out.println("pring methodB");
    }
}

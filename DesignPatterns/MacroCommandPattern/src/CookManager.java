/**
 * Created by marszhou on 16/9/7.
 */
public class CookManager {
    private static boolean runFlag = false;

    public static void runCookManager() {
        if (!runFlag) {
            runFlag = true;

            HotCook cook1 = new HotCook("张三");
            HotCook cook2 = new HotCook("李四");
            HotCook cook3 = new HotCook("王五");
            Thread thread1 = new Thread(cook1);
            Thread thread2 = new Thread(cook2);
            Thread thread3 = new Thread(cook3);
            thread1.start();
            thread2.start();
            thread3.start();
        }
    }
}

/**
 * Created by mars on 16/11/25.
 */
public class SingletonTwo {
    private volatile static SingletonTwo instance = null;

    private SingletonTwo() {
    }

    public static SingletonTwo getInstance() {
        if (instance == null) {
            synchronized (SingletonTwo.class) {
                if (instance == null) {
                    instance = new SingletonTwo();
                }
            }
        }
        return instance;
    }

    public String info() {
        return this.toString();
    }
}

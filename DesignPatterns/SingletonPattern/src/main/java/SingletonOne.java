/**
 * Created by mars on 16/11/25.
 */
public class SingletonOne {
    private static SingletonOne instance = new SingletonOne();

    private SingletonOne() {
    }

    public static SingletonOne getInstance() {
        return instance;
    }

    public String info() {
        return this.toString();
    }
}

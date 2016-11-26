/**
 * Created by marszhou on 16/2/4.
 */
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    // 责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            //这里其实是遍历了责任链上的所有后继元素
            //一般我们也可以只选择对应的职责执行完以后就结束遍历,不再将后继元素遍历
            //若如此做,则不需要判断后继指针的值,而是用具体条件筛选出唯一符合条件的那个元素
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}

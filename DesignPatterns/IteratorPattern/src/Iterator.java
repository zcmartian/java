/**
 * Created by marszhou on 16/9/8.
 */
public interface Iterator {
    void first();
    void next();
    boolean isDone();
    Object currentItem();
}

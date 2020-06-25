/**
 * Created by mars on 16/11/22.
 */
public class RedRect implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void drawRect(int x, int y, int height, int width) {
        System.out.println(
                "Drawing Rect[ color: red, x: " + x + ",y: " + y + ",height: " + height + ",width: " + width + "]");
    }
}

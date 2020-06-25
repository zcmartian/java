/**
 * Created by mars on 16/11/22.
 */
public class Rect extends Shape {
    private int x, y, height, width;

    public Rect(DrawAPI drawAPI, int x, int y, int hight, int width) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.height = hight;
        this.width = width;
    }

    @Override
    public void draw() {
        drawAPI.drawRect(x, y, height, width);
    }
}

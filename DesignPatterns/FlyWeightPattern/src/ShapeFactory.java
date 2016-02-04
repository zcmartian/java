import java.util.HashMap;

/**
 * Created by marszhou on 16/2/4.
 */
public class ShapeFactory {
    private static HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}

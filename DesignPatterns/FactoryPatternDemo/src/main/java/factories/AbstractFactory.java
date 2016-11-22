package factories;

import colors.Color;
import shapes.Shape;

/**
 * Created by marszhou on 16/1/24.
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);

    public abstract Shape getShape(String shape);
}

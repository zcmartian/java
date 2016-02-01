import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Properties properties = new Properties();
        InputStream inputStream = Main.class.getResourceAsStream("./config.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        ShapeFactory shapeFactory = new ShapeFactory();
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");

        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            Shape shape = shapeFactory.getShape(properties.getProperty(name));
            if (shape != null) {
                shape.draw();
            }
        }
        enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String name = (String) enumeration.nextElement();
            Color color = colorFactory.getColor(properties.getProperty(name));
            if (color != null) {
                color.fill();
            }
        }
    }
}

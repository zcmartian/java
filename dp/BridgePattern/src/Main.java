public class Main {

    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCircle = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCircle.draw();

        Shape redRect = new Rect(new RedRect(), 20, 40, 30, 10);
        Shape greenRect = new Rect(new GreenRect(), 20, 40, 30, 10);

        redRect.draw();
        greenRect.draw();
    }
}

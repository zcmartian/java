import java.io.IOException;

/**
 * Created by mars on 2017/1/24.
 */
public class ExceptionDemo {
    public static void main(String... args) {
        try {
            System.out.println("Try");
            throw new Exception("throw");
//            return;
        } catch(Exception e) {
            System.out.println("Catch");
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }
    }
}

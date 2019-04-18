import java.util.List;

/**
 * Created by mars on 2017/1/24.
 */
public class InstanceDemo{
    public static void main(String args[])
    {
//        System.out.println(new InstanceDemo() instanceof String);
        System.out.println(new InstanceDemo() instanceof Object);
        System.out.println(new InstanceDemo() instanceof List);
    }
}

/**
 * Created by marszhou on 16/8/31.
 */
public class ApiImplA implements Api{
    @Override
    public void operation(String s) {
        System.out.println("ApiImplA operation." + s);
    }
}

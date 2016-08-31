/**
 * Created by marszhou on 16/8/31.
 */
public class ApiImplB implements Api{
    @Override
    public void operation(String s) {
        System.out.println("ApiImplB operation." + s);
    }
}

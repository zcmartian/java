/**
 * Created by marszhou on 16/8/31.
 */
public class Client {
    public static void main(String[] args) {
        Api api = Factory.createApi(1);
        if (api != null) {
            api.operation("args is 1.");
        }
        api = Factory.createApi(2);
        if (api != null) {
            api.operation("args is 2.");
        }
    }
}

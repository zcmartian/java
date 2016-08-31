/**
 * Created by marszhou on 16/8/31.
 */
public class Factory {
    public static Api createApi(int condition) {
        if (condition == 1) {
            return new ApiImplA();
        } else if (condition == 2) {
            return new ApiImplB();
        } else {
            return null;
        }
    }
}

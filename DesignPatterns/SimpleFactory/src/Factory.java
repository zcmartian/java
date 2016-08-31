import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
            Properties properties = new Properties();
            InputStream inputStream = null;
            try {
                inputStream = Factory.class.getResourceAsStream("SimpleFactory.properties");
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
            Api api = null;
            try {
                api = (Api) Class.forName(properties.getProperty("ImplClass")).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return api;
        }
    }
}

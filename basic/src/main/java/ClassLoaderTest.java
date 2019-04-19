import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by mars on 2017/1/19.
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        try {
//            ClassLoader loader = ClassLoaderTest.class.getClassLoader(); // 获得ClassLoaderTest这个类的类加载器
//            while (loader != null) {
//                System.out.println(loader);
//                loader = loader.getParent(); // 获得父加载器的引用
//            }
//            System.out.println(loader);

            String rootUrl = "file:///Users/mars/Documents/apache-tomcat-8.5.9/webapps/httpweb/classes";
            NetworkClassLoader networkClassLoader = new NetworkClassLoader(rootUrl);
            String classname = "Main";
            Class clazz = networkClassLoader.loadClass(classname);
            System.out.println(clazz.getClassLoader());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class NetworkClassLoader extends ClassLoader {
    private String rootUrl;

    public NetworkClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        clazz = defineClass(name, classData, 0, classData.length);
        return clazz;
    }

    private byte[] getClassData(String name) {
        InputStream is = null;
        try {
            String path = classNameToPath(name);
            URL url = new URL(path);
            byte[] buff = new byte[1024 * 4];
            int len = -1;
            is = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            while ((len = is.read(buff)) != -1) {
                baos.write(buff, 0, len);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private String classNameToPath(String name) {
        return rootUrl + "/" + name.replace(".", "/") + ".class";
    }
}

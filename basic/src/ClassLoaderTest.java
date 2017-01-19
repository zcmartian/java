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

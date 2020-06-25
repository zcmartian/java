package jvm;

/**
 * Created by mars on 2017/1/18.
 */



public class ClassLoaderInitTest {

    public static void main(String[] args) throws Exception {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("CL");
        // loadClass方法加载一个类，并不是对类的主动使用，不会导致类的初始化

        System.out.println("----------------");
        clazz = Class.forName("CL");
    }

    static class CL {

        static {
            System.out.println("static block in CL");
        }
    }

}

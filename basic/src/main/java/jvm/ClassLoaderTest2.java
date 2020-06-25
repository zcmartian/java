package jvm;

import java.net.URL;

public class ClassLoaderTest2 {

    public static void main(String[] args) {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
        ClassLoader c = ClassLoaderTest2.class.getClassLoader(); // 获取Test类的类加载器
        System.out.println("jvm.ClassLoaderTest2.class classloader is : " + c);
        ClassLoader c1 = c.getParent(); // 获取c这个类加载器的父类加载器
        System.out.println("jvm.ClassLoaderTest2.class classloader's parent classloader is : " + c1);
        ClassLoader c2 = c1.getParent();// 获取c1这个类加载器的父类加载器
        System.out.println("jvm.ClassLoaderTest2.class classloader's parent classloader's parent classloader is : " + c2);

        System.out.println("System.getProperty(\"java.ext.dirs\") is : " + System.getProperty("java.ext.dirs"));
        System.out.println("System.getProperty(\"java.class.path\") is : " + System.getProperty("java.class.path"));
        ClassLoader extensionClassloader = ClassLoader.getSystemClassLoader().getParent();
        System.out.println("system classloader : " + ClassLoader.getSystemClassLoader());
        System.out.println("the parent of system classloader : " + extensionClassloader);
        System.out.println("the parent of extension classloader : " + extensionClassloader.getParent());

        try {
            A a = (A) Class.forName("A", false, A.class.getClassLoader()).newInstance();
            System.out.println("A class loader : " + A.class.getClassLoader());
            a.doSomething();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    class A {
        public void doSomething() {
            B b = new B();
            b.doSomethingElse();
        }
    }

    class B {
        public void doSomethingElse() {
            System.out.print("B class loader : " + this.getClass().getClassLoader());
        }
    }
}


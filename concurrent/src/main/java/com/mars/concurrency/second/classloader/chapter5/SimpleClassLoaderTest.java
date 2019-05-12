package com.mars.concurrency.second.classloader.chapter5;


public class SimpleClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("java.lang.String");
        Class<?> bClass = simpleClassLoader.loadClass("SimpleObject");
        System.out.println(aClass.getClassLoader());
        System.out.println(bClass.getClassLoader());
    }
}

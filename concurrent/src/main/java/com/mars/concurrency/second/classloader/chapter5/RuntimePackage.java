package com.mars.concurrency.second.classloader.chapter5;


public class RuntimePackage {
    //RuntimePackage
    //com.mars.concurrent.classloader.chapter5
    //Boot.Ext.App.com.mars.concurrent.classloader.chapter5

    //Boot.Ext.App.com.mars.concurrent.classloader.chapter5.SimpleClassLoaderTest
    //Boot.Ext.App.SimpleClassLoader.com.mars.concurrent.classloader.chapter5.SimpleClassLoaderTest

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Class<?> aClass = simpleClassLoader.loadClass("com.mars.concurrent.classloader.chapter5.SimpleObject");
        //sSystem.out.println(aClass.getClassLoader());
        SimpleObject simpleObject = (SimpleObject) aClass.newInstance();
    }
}

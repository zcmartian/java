package com.jikexueyuan.rpc.container;

/**
 * Created by version_z on 2015/8/22.
 */
public abstract class Container {
    public static volatile boolean isStart = false;
    public static volatile Container container = null;

    public abstract void start();
}

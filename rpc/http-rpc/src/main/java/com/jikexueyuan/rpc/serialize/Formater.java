package com.jikexueyuan.rpc.serialize;

/**
 * Created on 2015/8/17.
 */
public interface Formater {
    String reqFormat(Class clazz, String method, Object param);

    String rsbFormat(Object param);
}

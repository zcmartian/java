package com.jikexueyuan.rpc.invoke;

import java.io.OutputStream;

import com.jikexueyuan.rpc.exception.RpcException;

/**
 * Created by version_z on 2015/8/22.
 */
public interface Invoker {
    String request(String request, ConsumerConfig consumerConfig) throws RpcException;

    void response(String response, OutputStream outputStream) throws RpcException;
}

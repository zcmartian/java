package com.jikexueyuan.rpc.serialize;

import com.jikexueyuan.rpc.exception.RpcException;

/**
 * Created on 2015/8/17.
 */
public interface Parser {
    Request reqParse(String param) throws RpcException;

    <T> T rsbParse(String result);
}

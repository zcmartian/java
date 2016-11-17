package com.jikexueyuan.rpc.serialize.json;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.jikexueyuan.rpc.exception.RpcException;
import com.jikexueyuan.rpc.exception.RpcExceptionCodeEnum;
import com.jikexueyuan.rpc.serialize.Parser;
import com.jikexueyuan.rpc.serialize.Request;

/**
 * Created on 2015/8/17.
 */
public class JsonParser implements Parser {
    public static final Parser parser = new JsonParser();
    private static final Logger logger = LoggerFactory.getLogger(JsonParser.class);

    public Request reqParse(String param) throws RpcException {
        try {
            logger.debug(" 请求参数 {}", param);
            return (Request) JSON.parse(param);
        } catch (Exception e) {
            logger.error("参数转换异常", param, e);
            throw new RpcException("", e, RpcExceptionCodeEnum.DATA_PARSER_ERROR.getCode(), param);
        }
    }

    public <T> T rsbParse(String result) {
        return (T) JSON.parse(result);
    }
}

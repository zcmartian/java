package com.jikexueyuan.rpc.exception;

/**
 * Created on 2015/8/18.
 */
public enum RpcExceptionCodeEnum {
    DATA_PARSER_ERROR("DATA_PARSER_ERROR", "数据转换错误"), NO_BEAN_FOUND("NO_BEAN_FOUND",
            "BEAN 没有定义"), INVOKE_REQUEST_ERROR("INVOKE_REQUEST_ERROR", "RPC 请求错误"),;

    private String code;
    private String msg;

    RpcExceptionCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

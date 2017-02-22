package com.mars.netty.protocal;

/**
 * Created by mars on 2017/2/13.
 */
public class NettyMessage {
    private Header header;
    private Body body;

    @Override
    public String toString() {
        return "NettyMessage{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}

package com.mars.serialize;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by marszhou on 16/8/24.
 */
public class SubReqClientHandler extends ChannelHandlerAdapter {
    public SubReqClientHandler() {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        for (int i = 0; i < 10; ++i) {
            ctx.write(subReq(i));
        }
        ctx.flush();
    }

    private com.mars.serialize.SubscribeReq subReq(int i) {
        com.mars.serialize.SubscribeReq req = new com.mars.serialize.SubscribeReq();
        req.setAddress("Shanghai 安化路");
        req.setProductName("Netty 权威指南");
        req.setSubReqID(i);
        req.setUserName("marszhou");
        return req;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + msg.toString() + "]");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}

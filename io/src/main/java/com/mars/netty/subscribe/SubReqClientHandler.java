package com.mars.netty.subscribe;

import com.mars.protobuf.SubscribeReqProto;
import com.mars.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

import java.util.ArrayList;
import java.util.List;

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

    // private com.mars.serialize.SubscribeReq subReq(int i) {
    private SubscribeReqProto.SubscribeReq subReq(int i) {
        // com.mars.serialize.SubscribeReq req = new com.mars.serialize.SubscribeReq();
        SubscribeReqProto.SubscribeReq.Builder req = SubscribeReqProto.SubscribeReq.newBuilder();
        List<String> address = new ArrayList<String>();
        address.add("Shanghai 安化路");
        address.add("Shanghai 长岛路");
        address.add("Shanghai 纳贤路");
        req.addAllAddress(address);
        req.setProductName("Netty 权威指南");
        req.setSubReqID(i);
        req.setUserName("marszhou");
        return req.build();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : [" + ((SubscribeRespProto.SubscribeResp) msg).toString() + "]");
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

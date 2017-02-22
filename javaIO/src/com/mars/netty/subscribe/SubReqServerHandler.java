package com.mars.netty.subscribe;

import com.mars.protobuf.SubscribeReqProto;
import com.mars.protobuf.SubscribeRespProto;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * Created by marszhou on 16/8/24.
 */
public class SubReqServerHandler extends ChannelHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        // com.mars.serialize.SubscribeReq req = (com.mars.serialize.SubscribeReq) msg;
        SubscribeReqProto.SubscribeReq req = (SubscribeReqProto.SubscribeReq) msg;
        if ("marszhou".equalsIgnoreCase(req.getUserName())) {
            System.out.println("Service accept client subscribe req : [" + req.toString() + "]");
            ctx.writeAndFlush(resp(req.getSubReqID()));
        }
    }

    // private com.mars.serialize.SubscribeResp resp(int subReqID) {
    private SubscribeRespProto.SubscribeResp resp(int subReqID) {
        // com.mars.serialize.SubscribeResp subscribeResp = new com.mars.serialize.SubscribeResp();
        SubscribeRespProto.SubscribeResp.Builder subscribeResp = SubscribeRespProto.SubscribeResp.newBuilder();
        subscribeResp.setSubReqID(subReqID);
        subscribeResp.setRespCode(0);
        subscribeResp.setDesc("Netty book order succeed, 3 days later, sent to the designated address");
        // return subscribeResp;
        return subscribeResp.build();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        ctx.close();
    }
}

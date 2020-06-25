package socket.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.time.LocalDateTime;

public class MyClientHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 服务器端地址
        System.out.println("server:" + ctx.channel().remoteAddress());
        // 服务器向客户端发送的数据
        System.out.println("server sent to client" + msg);
        // 向服务器发送一个标准utc时间
        ctx.writeAndFlush("from client: " + LocalDateTime.now().toString());

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.getStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush("客户端与服务器连接了");
    }
}

package heartbeat.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class MyIdleStateServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 空闲状态,读空闲,写空闲,读写空闲
        pipeline.addLast(new IdleStateHandler(
                4, 4, 3, TimeUnit.SECONDS));
        pipeline.addLast(new MyIdleStateServerHandler());
    }
}

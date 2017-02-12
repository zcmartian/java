package com.mars;

/**
 * Created by marszhou on 16/8/26.
 */

import java.io.File;
import java.io.RandomAccessFile;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.FileRegion;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Administrator
 * @date 2014年3月9日
 * @version 1.0
 */
public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    private static final String CR = System.getProperty("line.separator");

    /*
     * (non-Javadoc)
     * @see io.com.mars.protobuf.channel.SimpleChannelInboundHandler#messageReceived(io.com.mars.protobuf .channel.ChannelHandlerContext,
     * java.lang.Object)
     */
    public void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        File file = new File(msg);
        if (file.exists()) {
            if (!file.isFile()) {
                ctx.writeAndFlush("Not a file : " + file + CR);
                return;
            }
            ctx.write(file + " " + file.length() + CR);
            RandomAccessFile randomAccessFile = new RandomAccessFile(msg, "r");
            FileRegion region = new DefaultFileRegion(randomAccessFile.getChannel(), 0, randomAccessFile.length());
            ctx.write(region);
            ctx.writeAndFlush(CR);
            randomAccessFile.close();
        } else {
            ctx.writeAndFlush("File not found: " + file + CR);
        }
    }

    /*
     * (non-Javadoc)
     * @see io.com.mars.protobuf.channel.ChannelHandlerAdapter#exceptionCaught(io.com.mars.protobuf.channel .ChannelHandlerContext,
     * java.lang.Throwable)
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

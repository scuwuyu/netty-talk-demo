package com.scuwuyu.talk.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 吴宇 on 2018-01-24.
 */
public class HelloChannelHandler extends SimpleChannelInboundHandler<String> {
    private static final Logger log = LoggerFactory.getLogger(HelloChannelHandler.class);

    /** message received method*/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 收到消息直接打印输出
        System.out.println(msg);
        if (!msg.contains("已读")){
            ctx.writeAndFlush("已读!\n");
        }
    }

    /** channel active method */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ServerSide.mapCache.put(ctx.channel().remoteAddress().toString(),ctx.channel());

        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ServerSide.mapCache.remove(ctx.channel().remoteAddress().toString());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "关闭了链接");
        //super.exceptionCaught(ctx, cause);
    }
}

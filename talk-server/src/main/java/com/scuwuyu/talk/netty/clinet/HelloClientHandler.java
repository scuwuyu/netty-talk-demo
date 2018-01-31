package com.scuwuyu.talk.netty.clinet;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by wuyu on 2018/1/26.
 */
public class HelloClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        if (!msg.contains("已读")){
            ctx.writeAndFlush("已读\n");
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("Client active");
        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("Client close");
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+"server close connect");
//        super.exceptionCaught(ctx, cause);
    }
}

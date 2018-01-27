package com.scuwuyu.talk.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by 吴宇 on 2018-01-24.
 */
public class HelloChannelHandler extends SimpleChannelInboundHandler<String> {

    /** message received method*/
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        // 收到消息直接打印输出
        ServerPrintUtil.printWithNameAndDate(msg);

        ctx.writeAndFlush("Received your message!\n");
    }

    /** channel active method */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        System.out.println("remoteaddress:"+ctx.channel().remoteAddress()+" active");
//
//        ctx.writeAndFlush("Welcome to "+ InetAddress.getLocalHost().getHostName() +"service!");

        super.channelActive(ctx);
    }
}

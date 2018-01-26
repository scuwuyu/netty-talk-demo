package com.scuwuyu.talk.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;

import java.nio.charset.Charset;

/**
 * Created by 吴宇 on 2018-01-24.
 */
public class MyChannelHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {
        if (msg instanceof HttpRequest){
//            ByteBuf byteBuf = Unpooled.copiedBuffer("hello wuyu", Charset.forName("utf8"));

            ctx.writeAndFlush("hello wuyu");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connect finish");
        super.channelActive(ctx);
    }
}

package com.scuwuyu.talk.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpObject;

import java.nio.charset.Charset;

/**
 * Created by 吴宇 on 2018-01-24.
 */
public class MyChannelHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject msg) throws Exception {

        ByteBuf byteBuf = Unpooled.copiedBuffer("hello wuyu", Charset.forName("utf8"));

        Channel channel = ctx.channel();
        channel.writeAndFlush(byteBuf);
    }
}

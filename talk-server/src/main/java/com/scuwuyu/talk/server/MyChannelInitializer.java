package com.scuwuyu.talk.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * Created by 吴宇 on 2018-01-24.
 */
public class MyChannelInitializer extends ChannelInitializer {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast("httpServerCodec",new HttpServerCodec());

        channelPipeline.addLast(new MyChannelHandler());
    }
}

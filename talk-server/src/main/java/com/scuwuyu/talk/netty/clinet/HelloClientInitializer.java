package com.scuwuyu.talk.netty.clinet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by wuyu on 2018/1/26.
 */
public class HelloClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();

        channelPipeline.addLast("framer",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        channelPipeline.addLast("encoder",new StringEncoder());
        channelPipeline.addLast("decoder",new StringDecoder());

        // 客户端的逻辑
        channelPipeline.addLast("handler",new HelloClientHandler());
    }
}

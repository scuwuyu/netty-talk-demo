package com.scuwuyu.talk.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by 吴宇 on 2018-01-24.
 */
public class HelloChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
        // 以("\n")为结尾分割的 解码器
        channelPipeline.addLast("frame",new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // 字符串解码 和 编码
        channelPipeline.addLast("decoder",new StringDecoder());
        channelPipeline.addLast("encoder",new StringEncoder());

        // 自己的逻辑Handler
        channelPipeline.addLast("handler",new HelloChannelHandler());

        channelPipeline.addLast("outboundhandler",new HelloOutboundHandler());

    }
}

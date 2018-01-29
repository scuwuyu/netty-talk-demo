package com.scuwuyu.talk.server;

import com.scuwuyu.talk.entyties.MsgBody;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

/**
 * Created by wuyu on 2018/1/29.
 */
public class HelloOutboundHandler extends ChannelOutboundHandlerAdapter {

    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        if (msg instanceof MsgBody){
            System.out.println("this is msg");
        }
        super.write(ctx, msg, promise);
    }
}

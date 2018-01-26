package com.scuwuyu.talk.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * Created by wuyu on 2018/1/26.
 */
public class MyChannelInboundHandlerAdapter extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello my name is wuyu\n",CharsetUtil.UTF_8);

        ctx.writeAndFlush(byteBuf);
        ctx.close();

//        ReferenceCountUtil.release(byteBuf);
//        ByteBuf byteBuf = (ByteBuf)msg;
//
//        try {
//            System.out.println(byteBuf.toString(CharsetUtil.UTF_8));
////            while (byteBuf.isReadable()){
////                System.out.print((char) byteBuf.readByte());
////            }
//        }finally {
//            ReferenceCountUtil.release(msg);
//        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();

        ctx.close();
    }
}

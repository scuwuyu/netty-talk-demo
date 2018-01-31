package com.scuwuyu.talk.netty.server;

import com.scuwuyu.talk.netty.common.OnlineClient;
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
        boolean success = OnlineClient.sendMsg(ctx.channel(),msg);

        if(!success&&!msg.contains("已读")){
            ctx.writeAndFlush("没有客户端接收!\n");
        }

    }

    /** channel active method */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        OnlineClient.regist(ctx.channel(),ctx);

        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        OnlineClient.unRegist(ctx.channel());
        super.channelInactive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "关闭了链接");
        OnlineClient.unRegist(ctx.channel());
//        super.exceptionCaught(ctx, cause);
    }
}

package com.scuwuyu.talk.netty.clinet;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

/**
 * 聊天客户端
 * Created by wuyu on 2018/1/24.
 */
public class ClientSide2 {

    public static void main(String[] args) throws Exception{
        EventLoopGroup loopGroup = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(loopGroup)
                    .channel(NioSocketChannel.class)
                    .handler(new HelloClientInitializer());

            // 连接服务端
            Channel channel = bootstrap.connect("127.0.0.1",8033).sync().channel();

            // 控制台输入
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            while (true){
                String content = in.readLine();
                if (Objects.isNull(content)){
                    continue;
                }
                //之所以用\r\n结尾 是因为我们在handler中添加了 DelimiterBasedFrameDecoder 帧解码。
                channel.writeAndFlush(content+"\r\n");

            }

        }finally {
            loopGroup.shutdownGracefully();
        }


    }
}

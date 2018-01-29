package com.scuwuyu.talk.server;

import com.scuwuyu.talk.entyties.MsgBody;
import com.scuwuyu.talk.enums.ServerType;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 聊天服务端
 * Created by wuyu on 2018/1/24.
 */
public class ServerSide {
    /** 客户端链接的缓存
     * key: ip:port
     * value: channel
     *
     */
    public static final Map<String, Channel> mapCache = new ConcurrentHashMap<String, Channel>();

    public static void main(String[] args) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                    .childHandler(new HelloChannelInitializer())
                    .option(ChannelOption.SO_BACKLOG,1024)
                    .childOption(ChannelOption.SO_KEEPALIVE,true);

            ChannelFuture channelFuture = bootstrap.bind(8033).sync();

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                String content = reader.readLine();
                if (StringUtils.isEmpty(content)){
                    continue;
                }

                MsgBody msgBody = new MsgBody(ServerType.SERVER,content);

                Set<Map.Entry<String, Channel>> entrySet = mapCache.entrySet();
                for (Map.Entry<String, Channel> entry : entrySet){
                    Channel chc = entry.getValue();
                    chc.writeAndFlush(msgBody+"\n");
                }


            }

            // Wait until the connection is closed.
            //channelFuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }



    }
}

package com.scuwuyu.talk.netty.common;

import com.scuwuyu.talk.netty.entyties.MsgBody;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在线客户端统计
 * Created by wuyu on 2018/1/30.
 */
public class OnlineClient {
    private final static ConcurrentHashMap<Channel,ChannelHandlerContext> USERMAP = new ConcurrentHashMap<Channel, ChannelHandlerContext>();

    private static AtomicInteger userId = new AtomicInteger(1);

    /** 注册并返回当前客户端id */
    public static void regist(Channel channel,ChannelHandlerContext channelHandlerContext){
        USERMAP.put(channel,channelHandlerContext);
    }

    public static void unRegist(Channel channel){
        USERMAP.remove(channel);
    }

    public static ChannelHandlerContext get(Channel channel){
        return USERMAP.get(channel);
    }


    public static boolean sendMsg(Channel currentChannel,String msg){
        /** 如果有其他客户端则发送消息*/
        if (USERMAP.size()>1){
            Set<Map.Entry<Channel,ChannelHandlerContext>> entrySet = USERMAP.entrySet();
            for (Map.Entry<Channel,ChannelHandlerContext> entry : entrySet){
                Channel channel = entry.getKey();
                if (!channel.equals(currentChannel)){
                    channel.writeAndFlush(msg+"\r\n");
                }
            }

            return true;
        }

        return false;
    }
}

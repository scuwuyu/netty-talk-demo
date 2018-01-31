package com.scuwuyu.talk.netty.entyties;

import com.scuwuyu.talk.enums.ServerType;
import com.scuwuyu.talk.util.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by wuyu on 2018/1/29.
 */
public class MsgBody implements Serializable{
    private String name;

    /** 发送消息userid*/
    private Integer fromUserId;

    /** 接受消息userid*/
    private Integer toUserId;

    private String msg;

    private Date sendTime = DateUtils.getNow();

    public MsgBody(ServerType type, String msg) {
        this.name = type.getName();
        this.msg = msg;
        this.sendTime = DateUtils.getNow();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Integer getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Integer fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Integer getToUserId() {
        return toUserId;
    }

    public void setToUserId(Integer toUserId) {
        this.toUserId = toUserId;
    }
}

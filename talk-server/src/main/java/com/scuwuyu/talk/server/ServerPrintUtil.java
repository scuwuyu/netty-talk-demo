package com.scuwuyu.talk.server;

import com.scuwuyu.talk.util.DateUtils;

/**
 * Created by wuyu on 2018/1/26.
 */
public class ServerPrintUtil {

    public static void printWithNameAndDate(String msg){
        System.out.println("Server "+ DateUtils.format(DateUtils.getNow())+":"+msg);
    }
}

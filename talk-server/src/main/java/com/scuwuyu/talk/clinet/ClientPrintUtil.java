package com.scuwuyu.talk.clinet;

import com.scuwuyu.talk.util.DateUtils;

/**
 * Created by wuyu on 2018/1/26.
 */
public class ClientPrintUtil {

    public static void printWithNameAndDate(String msg){
        System.out.println("Client "+ DateUtils.format(DateUtils.getNow())+":"+msg);
    }


}

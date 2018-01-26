package com.scuwuyu.talk.util;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wuyu on 2018/1/26.
 */
public class DateUtils {

    public static final String NORMAL = "yyyy-MM-dd HH:mm:ss";

    /** 获取当前时间 */
    public static Date getNow(){

        // new Date 的实现为 this(System.currentTimeMillis())
        return new Date();
    }

    public static String format(Date date) {
        return format(date,NORMAL);
    }

    public static String format(Date date,String pattern){
        DateFormat format = new SimpleDateFormat(pattern);

        return format.format(date);
    }

}

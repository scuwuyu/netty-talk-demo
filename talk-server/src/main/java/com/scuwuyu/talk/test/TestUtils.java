package com.scuwuyu.talk.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by wuyu on 2018/1/26.
 */
public class TestUtils {

    public static void main(String[] args) {
        for (first();second();third()){
            System.out.println("finish");
        }

        ArrayList<String> list = new ArrayList<String>();

        list.add("dd");
        list.add("dd1");
        list.add("dd1");

        list.remove(1);

        list.remove("dd");

    }


    public static boolean first(){
        System.out.println("11111");
        return false;
    }

    public static boolean second(){
        System.out.println("22222");
        return true;
    }

    public static boolean third(){
        System.out.println("33333");
        return false;
    }
}

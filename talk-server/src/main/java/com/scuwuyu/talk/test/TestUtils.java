package com.scuwuyu.talk.test;

import com.alibaba.fastjson.JSON;

/**
 * Created by wuyu on 2018/1/26.
 */
public class TestUtils {

    public static void main(String[] args) {
        User user = new User("wuyu");
        user.setAge(30);

        System.out.println(JSON.toJSONString(user));
    }


    public void say(){
        TestUtils.this.say();
        System.out.println("say hello");
    }
}

package com.scuwuyu.talk.test;

/**
 * Created by wuyu on 2018/1/26.
 */
public class AnonymousTest {

    public static void main(String[] args) {

        test(new User("wuyu"));


    }


    public static void test(User user){
        System.out.println(user.getName());
    }
}

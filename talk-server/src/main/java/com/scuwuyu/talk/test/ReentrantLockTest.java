package com.scuwuyu.talk.test;

/**
 * Created by wuyu on 2018/2/9.
 */
public class ReentrantLockTest extends Parent {

    public static void main(String[] args) {
        sayHello();
    }

    public static synchronized void sayHello(){
        Parent.say();
        System.out.println("child say hello");
    }
}

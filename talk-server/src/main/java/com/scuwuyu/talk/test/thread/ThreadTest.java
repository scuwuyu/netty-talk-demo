package com.scuwuyu.talk.test.thread;

/**
 * Created by wuyu on 2018/3/13.
 */
public class ThreadTest {

    public static void main(String[] args) {
        System.out.println("ddd");
        Thread.currentThread().stop();
        System.out.println("ddd");
    }
}

package com.scuwuyu.talk.test.thread;

import com.alibaba.fastjson.JSON;
import com.scuwuyu.talk.test.User;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutionException;

/**
 * Created by wuyu on 2018/2/28.
 */
public class ExchangerTest {

    public static void main(String[] args) throws Exception{
        final Exchanger<User> exchanger = new Exchanger<User>();

        Thread thread1 = new Thread(new Runnable() {
            public void run(){
                User user = new User("user1");
                try {
                    user = exchanger.exchange(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"="+ JSON.toJSONString(user));
            }
        },"thread1");

        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            public void run(){
                User user = new User("user2");
                try {
                    user = exchanger.exchange(user);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"="+ JSON.toJSONString(user));
            }
        },"thread2");

        thread2.start();
    }


}

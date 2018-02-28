package com.scuwuyu.talk.test.thread;

import java.util.Random;

/**
 * Created by wuyu on 2018/2/28.
 */
public class YieldTest {

    public static void main(String[] args) throws Exception {
        Thread thread1 = new Thread(new MyRunnable(),"thread1");
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(new MyRunnable(),"thread2");
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(new MyRunnable(),"thread3");
        thread3.start();
        thread3.join();
    }



    private static class MyRunnable implements Runnable{
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(2000));
            }catch (Exception e){
                // do nothing
            }

            System.out.println("name="+Thread.currentThread().getName());
        }
    }
}

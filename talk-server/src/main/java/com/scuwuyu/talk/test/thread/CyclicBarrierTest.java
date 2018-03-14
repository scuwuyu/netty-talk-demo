package com.scuwuyu.talk.test.thread;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by wuyu on 2018/2/28.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            public void run() {
                System.out.println("人到齐了");
            }
        });
        for (int i=0;i<10;i++){
            Thread thread = new Thread(new MyRunnable(cyclicBarrier),"thread"+(i+1));
            thread.start();
        }

    }



    private static class MyRunnable implements Runnable{

        private CyclicBarrier cyclicBarrier;

        public MyRunnable(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"到了");
                cyclicBarrier.await();
            }catch (Exception e){
                // do nothing
            }

        }
    }
}

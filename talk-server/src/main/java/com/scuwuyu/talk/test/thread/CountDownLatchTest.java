package com.scuwuyu.talk.test.thread;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * Created by wuyu on 2018/2/28.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Thread thread1 = new Thread(new MyRunnable(countDownLatch),"thread1");
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable(countDownLatch),"thread2");
        thread2.start();

        Thread thread3 = new Thread(new MyRunnable(countDownLatch),"thread3");
        thread3.start();

        countDownLatch.await();
        System.out.println("end");

    }



    private static class MyRunnable implements Runnable{

        private CountDownLatch countDownLatch;

        public MyRunnable(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }

        public void run() {
            try {
                Thread.sleep(new Random().nextInt(2000));
            }catch (Exception e){
                // do nothing
            }
            System.out.println("name="+Thread.currentThread().getName());

            if (Objects.nonNull(countDownLatch)){
                countDownLatch.countDown();
            }
        }
    }
}

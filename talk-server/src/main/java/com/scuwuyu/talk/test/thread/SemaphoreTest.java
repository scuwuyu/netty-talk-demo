package com.scuwuyu.talk.test.thread;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/**
 * Created by wuyu on 2018/2/28.
 */
public class SemaphoreTest {

    public static void main(String[] args) throws Exception {
        int people = 10;//总人数为10

        Semaphore semaphore = new Semaphore(5);//厕所坑位只有5个

        for (int i=0;i<people;i++){
            new Thread(new MyRunnable(i,semaphore)).start();
        }

    }



    private static class MyRunnable implements Runnable{

        private Integer num;

        private Semaphore semaphore;

        public MyRunnable(Integer num,Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第"+num+"人正在上厕所");
                Thread.sleep(500);
                System.out.println("第"+num+"人使用完毕");
                semaphore.release();
            }catch (Exception e){
                // do nothing
            }

        }
    }
}

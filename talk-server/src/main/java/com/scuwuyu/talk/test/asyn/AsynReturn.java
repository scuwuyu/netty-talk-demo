package com.scuwuyu.talk.test.asyn;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *  异步结果同步返回
 *  借鉴dubbo 通过netty异步返回消息，同步返回调用结果
 * Created by wuyu on 2018/3/20.
 */
public class AsynReturn {

    public static void main(String[] args) {
        final AtomicInteger integer = new AtomicInteger(0);

        for (int j=0;j<5;j++){
            new Thread(){
                @Override
                public void run() {
                    Integer i = integer.incrementAndGet();
                    new Thread(new MyRunnable(i)).start();

                    DefaultFuture future = new DefaultFuture(i);
                    System.out.println("返回结果="+future.get());
                }
            }.start();
        }





    }



    private static class MyRunnable implements Runnable{

        private Integer id;

        public MyRunnable(Integer id) {
            this.id = id;
        }

        public void run() {

            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            DefaultFuture.receive(id);
        }
    }



    private static class DefaultFuture{
        public static final Map<Integer,DefaultFuture> FUTURES = new ConcurrentHashMap<Integer, DefaultFuture>();

        private String result;

        public DefaultFuture(Integer integer) {
            FUTURES.put(integer,this);
        }

        public String get() {
            while (Objects.isNull(result)){
                try {
//                    System.out.println("main线程等待");
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    System.out.println("线程错误");
                }
            }

            return result;
        }

        public static void receive(Integer id){
            DefaultFuture future = FUTURES.remove(id);
            if (Objects.nonNull(future)){
                future.setResult("id="+id);
            }
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}

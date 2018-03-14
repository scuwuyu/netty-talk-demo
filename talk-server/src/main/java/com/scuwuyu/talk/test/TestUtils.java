package com.scuwuyu.talk.test;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * Created by wuyu on 2018/1/26.
 */
public class TestUtils {

    private User user = new User("dd"){
        @Override
        public void setName(String name) {
            super.setName(name);
            foo();
        }
    };

    public static void main(String[] args) {
        int num = 4;
        int currentNum = 1;
        int exit = 0;
        Boolean[] array = new Boolean[num];
        for (int i=0;i<num;i++){
            array[i] = true;
        }
        for (int i=0;i<num;i++){
            if (!array[i]){
                if (i==num-1){
                    i=-1;
                }
                continue;
            }
            if (currentNum == 3){
                array[i] = false;
                currentNum = 1;
                if (++exit==num-1){
                    System.out.println("退出人数达到");
                    break;
                }
            }else{
                currentNum++;
            }

            if (i==num-1){
                i=-1;
            }
        }

        for (int i=1;i<=num;i++){
            if (array[i-1]){
                System.out.println("剩余为"+i);
            }
        }


    }


    public static boolean first(){
        System.out.println("11111");
        return false;
    }

    public static boolean second(){
        System.out.println("22222");
        return false;
    }

    public static boolean third(){
        System.out.println("33333");
        return false;
    }

    public boolean foo(){
        System.out.println("33333");
        return false;
    }


}

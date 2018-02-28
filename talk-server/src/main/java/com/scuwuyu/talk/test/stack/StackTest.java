package com.scuwuyu.talk.test.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 实现栈 先进后出、栈高度的伪代码
 * Created by wuyu on 2018/2/27.
 */
public class StackTest {

    private static final List<Object> stackList = new ArrayList<Object>();

    public void save(Object obj){
        stackList.add(obj);
    }

    public Object get(){
        int size = stackList.size();
        if (size==0){
            return null;
        }
        Object obj = stackList.get(size-1);
        stackList.remove(size-1);
        return obj;
    }

    public int size(){
        return stackList.size();
    }


    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        stackTest.save(1);
        stackTest.save(2);
        stackTest.save("www");
        stackTest.save("fds");
        System.out.println("size="+stackTest.size());
        System.out.println(stackTest.get());
        System.out.println("size="+stackTest.size());
        System.out.println(stackTest.get());
        System.out.println("size="+stackTest.size());
        System.out.println(stackTest.get());

    }



}

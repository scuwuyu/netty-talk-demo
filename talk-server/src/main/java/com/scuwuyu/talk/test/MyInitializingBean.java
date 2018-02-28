package com.scuwuyu.talk.test;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by wuyu on 2018/2/7.
 */
public class MyInitializingBean implements InitializingBean {

    private String name;

    public MyInitializingBean(String name) {
        System.out.println("constructor method");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void afterPropertiesSet() throws Exception {

        System.out.println("name="+name);

    }
}

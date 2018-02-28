package com.scuwuyu.talk.test;

/**
 * Created by wuyu on 2018/1/26.
 */
public class User {

    public User(String name) {
        this.name = name;
    }

    private volatile transient String name;

    private transient Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

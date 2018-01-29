package com.scuwuyu.talk.enums;

/**
 * Created by wuyu on 2018/1/29.
 */
public enum ServerType {
    SERVER("server"),
    CLIENT("client");

    ServerType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
}

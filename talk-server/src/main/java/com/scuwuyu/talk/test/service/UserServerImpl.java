package com.scuwuyu.talk.test.service;

import com.scuwuyu.talk.test.User;

/**
 * Created by 吴宇 on 2018-01-27.
 */
public class UserServerImpl implements UserService {
    public void insert(User user) {
        System.out.println("save success");
    }
}

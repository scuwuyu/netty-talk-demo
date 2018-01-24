package com.scuwuyu.talk.apis;

import com.scuwuyu.talk.dtos.SaveUserDto;
import com.scuwuyu.talk.dtos.UpdateUserDto;

import javax.validation.constraints.NotNull;

/**
 * dubboService，调用localService服务，目前只公开需要开放出去的接口
 */
public interface UserDubboService {


    /**
     * 更新，以update开头
     *
     * @return
     */
    Boolean updateUser(@NotNull(message = "test_1001") UpdateUserDto dto);

    /**
     * 插入，以save开头
     *
     * @return
     */
    Long saveUser(@NotNull(message = "test_1001") SaveUserDto dto);


}

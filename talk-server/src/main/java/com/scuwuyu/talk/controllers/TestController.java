package com.scuwuyu.talk.controllers;

import com.scuwuyu.talk.apis.UserDubboService;
import com.scuwuyu.talk.responses.TestResponse;
import com.scuwuyu.talk.requests.TestRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class TestController {

    @Autowired
    private UserDubboService testDubboService;

    /**
     * 如果需要校验参数，@Valid注解一定需要加，否则校验不会生效
     *
     * @param request
     * @return 返回值的问题，框架里默认会包装一个Result对象，会包含code， descrition 与业务对象，请不要自己封装code，description，只需要返回业务对象（XXXResponse）
     */
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    public TestResponse test(@Valid TestRequest request) {

        return new TestResponse();
    }
}

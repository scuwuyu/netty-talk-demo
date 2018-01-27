package com.scuwuyu.talk.test.aop;

import com.scuwuyu.talk.test.User;
import com.scuwuyu.talk.test.service.UserServerImpl;
import com.scuwuyu.talk.test.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 吴宇 on 2018-01-27.
 */
public class JDKProxy implements InvocationHandler {

    public JDKProxy(Object target) {
        this.target = target;
    }

    private Object target;

    /** 获取代理类对象实例*/
    public Object getProxy(){
        /** 真正生成代理实例的地方*/
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);

    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("参数="+args);

        return method.invoke(target,args);
    }

    public static void main(String[] args) {
        UserService userService = new UserServerImpl();
        JDKProxy proxy = new JDKProxy(userService);
        UserService userProxy = (UserService)proxy.getProxy();

        userProxy.insert(new User("wuyu"));
    }
}

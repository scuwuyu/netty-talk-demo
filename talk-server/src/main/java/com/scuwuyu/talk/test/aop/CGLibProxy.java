package com.scuwuyu.talk.test.aop;

import com.scuwuyu.talk.test.User;
import com.scuwuyu.talk.test.service.UserService;
import com.scuwuyu.talk.test.service.impl.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 吴宇 on 2018-01-27.
 */
public class CGLibProxy {

//    private Object target;

    public Object createProxy(final Object target){
//        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setClassLoader(target.getClass().getClassLoader());
        /** 设置callback对象*/
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("argments="+objects);
                return methodProxy.invoke(target,objects);
            }
        });
        Object proxy = enhancer.create();
        System.out.println(proxy.getClass().getSuperclass().getName());
        proxy.getClass().getSuperclass().getName();
        return proxy;
    }


    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        UserService userServce = (UserService)proxy.createProxy(new UserServiceImpl());

        userServce.insert(new User("wangdan"));

    }

}

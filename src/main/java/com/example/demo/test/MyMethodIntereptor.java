package com.example.demo.test;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther houwanfei
 * @create 2018-01-18 下午12:52
 */
public class MyMethodIntereptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke :" + System.currentTimeMillis());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after invoke :" + System.currentTimeMillis());
        return object;
    }
}

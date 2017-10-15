package com.example.demo.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by houwanfei on 2017/8/6.
 */
public class DynamicProxyHanler implements InvocationHandler {
    private Object proxyed;

    public DynamicProxyHanler(Object proxyed){
        this.proxyed = proxyed;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("interesting".equals(method.getName())){
            System.out.println("=====interesting======");
        }
        System.out.println(proxy.getClass());
        Long statrTime = System.currentTimeMillis();
        method.invoke(proxyed,args);
        Thread.sleep(1000);
        Long endTime = System.currentTimeMillis();
        System.out.println(endTime-statrTime);
        return null;
    }
}

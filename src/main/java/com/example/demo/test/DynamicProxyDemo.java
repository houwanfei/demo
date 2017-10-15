package com.example.demo.test;

import java.lang.reflect.Proxy;

/**
 * Created by houwanfei on 2017/8/6.
 */
public class DynamicProxyDemo {
    public static void main(String[] args){
        SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
                SomeMethods.class.getClassLoader(),
                new Class[]{SomeMethods.class},
                new DynamicProxyHanler(new MethodImpl())
        );

        proxy.method1();
        proxy.method2();
        proxy.method3();
        proxy.interesting("BigBig");
    }
}

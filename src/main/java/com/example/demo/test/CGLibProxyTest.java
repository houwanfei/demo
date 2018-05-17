package com.example.demo.test;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @auther houwanfei
 * @create 2018-01-18 下午12:56
 */
public class CGLibProxyTest {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MethodImpl.class);
        enhancer.setCallback(new MyMethodIntereptor());
        MethodImpl method = (MethodImpl) enhancer.create();

        method.method1();
        method.interesting("hh");
    }
}

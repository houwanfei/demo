package com.example.demo.test;

/**
 * Created by houwanfei on 2017/8/6.
 */
public class MethodImpl implements SomeMethods {
    @Override
    public void method1() {
        System.out.println("merhod1");
    }

    @Override
    public void method2() {
        System.out.println("merhod2");
    }

    @Override
    public void method3() {
        System.out.println("merhod3");
    }

    @Override
    public void interesting(String arg) {
        System.out.println("interesting"+arg);
    }
}

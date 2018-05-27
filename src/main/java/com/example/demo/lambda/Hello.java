package com.example.demo.lambda;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

/**
 * @auther houwanfei
 * @create 2018-01-16 下午3:50
 */
public class Hello {
    Runnable r1 = () -> { System.out.println(this); };
    Runnable r2 = () -> { System.out.println(toString()); };

    @Override
    public String toString() {
        return "Hello";
    }

    public static void main(String[] args) throws IOException {
        new Hello().r1.run();
        new Hello().r2.run();
        System.in.read();
    }
}

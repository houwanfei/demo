package com.example.demo.test;

public class JitTest {
    public static void main(String[] args) {
        for (int i =0; i< 100000; i++){
            test();
        }
        System.out.println("ok");
    }

    private static void test(){
        int i = 1;
        i++;
    }
}

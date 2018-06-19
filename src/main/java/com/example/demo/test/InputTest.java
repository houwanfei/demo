package com.example.demo.test;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @auther houwanfei
 * @create 2018-05-24 下午4:02
 */
public class InputTest {
    public static void main(String[] args) throws Exception {
        FileInputStream is = new FileInputStream("/Users/anonymous/Downloads/test.jpg");
        FileInputStream is2 = new FileInputStream("/Users/anonymous/Downloads/test.jpg");

        FileDescriptor fd = is.getFD();
        FileDescriptor fd2 = is2.getFD();

        if (fd != null && fd2 != null){
            System.out.println(fd);
            System.out.println(fd2);
        }
    }
}

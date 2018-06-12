package com.example.demo.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @auther houwanfei
 * @create 2018-05-29 下午2:25
 */
public class FileChannelTest {
    public static void main(String[] args) throws Exception{
        FileInputStream fis = new FileInputStream("/Users/anonymous/Documents/path");
        FileChannel fc = fis.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        buffer.flip();
        byte[] bytes = buffer.array();

        String str = new String(bytes, "UTF-8");
        System.out.println(str);
    }
}

package com.example.demo.io;

import java.nio.ByteBuffer;

public class TestBuffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        byteBuffer.put((byte)1);
        byteBuffer.put((byte)2);
        byteBuffer.put((byte)3);
        byteBuffer.put((byte)4);
        byteBuffer.flip();
        System.out.println("第一次读取:" + byteBuffer.get());
        byteBuffer.compact();
        byteBuffer.put((byte)5);
        //byteBuffer.put((byte)6);
        byteBuffer.flip();
        for (int i=0; i< 4; i++) {
            System.out.println("第二次读取:" + byteBuffer.get());
        }
    }
}

//package com.example.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * @auther houwanfei
 * @create 2018-06-05 下午4:48
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        int size = 1000000;
        ByteBuffer[] buffers = new ByteBuffer[size];
        for (int i=0; i<size; i++){
            buffers[i] = ByteBuffer.allocate(1024);
            //buffers[i] = ByteBuffer.allocateDirect(1024);
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

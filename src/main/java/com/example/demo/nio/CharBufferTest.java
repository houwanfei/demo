package com.example.demo.nio;

import java.nio.CharBuffer;

/**
 * @auther houwanfei
 * @create 2018-06-05 下午3:01
 */
public class CharBufferTest {
    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(8);
        buffer.position(3).limit(6).mark().position(4);
        CharBuffer duBuffer = buffer.duplicate();
        System.out.println(buffer == duBuffer);
        duBuffer.put('c');
        CharBuffer slBuffer = buffer.slice();
        System.out.println("");
    }
}

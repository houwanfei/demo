package com.example.demo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {
    public static void main(String[] args) throws Exception {
        FileInputStream fis = new FileInputStream("/home/ikan/文档/data");
        FileChannel fc = fis.getChannel();
        System.out.println(fc.size());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        fc.read(buffer);
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        buffer.flip();
        CharBuffer cb = decoder.decode(buffer);
        System.out.println(cb);
    }
}

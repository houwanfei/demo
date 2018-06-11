package com.example.demo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ScatterChannelTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/home/ikan/文档/data");
        ScatteringByteChannel channel = fis.getChannel();

        ByteBuffer[] buffers = new ByteBuffer[2];
        buffers[0] = ByteBuffer.allocate(10);
        buffers[1] = ByteBuffer.allocate(1024);

        channel.read(buffers);

        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        buffers[0].flip();
        CharBuffer charBuffer = decoder.decode(buffers[0]);
        System.out.println(charBuffer);
        System.out.println("ok");
    }
}

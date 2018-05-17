package com.example.demo.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @auther houwanfei
 * @create 2018-04-02 上午9:31
 */
public class NIOTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("/Users/anonymous/Documents/path", "rw");
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            ByteBuffer byteBuffer1 = ByteBuffer.allocate(96);
            FileChannel fileChannel = file.getChannel();
            ByteBuffer[] byteBuffers = {byteBuffer, byteBuffer1};
            long read = fileChannel.read(byteBuffers);
            //int read = fileChannel.read(byteBuffer);
            int i = 0;
            while (read != -1) {
                System.out.println(read);
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()){
                    System.out.println(byteBuffer.get());
                }
                byteBuffer.clear();
                byteBuffer1.clear();
                read = fileChannel.read(byteBuffers);
                System.out.println("i:" + i);
                i++;
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

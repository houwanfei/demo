package com.example.demo.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @auther houwanfei
 * @create 2018-04-02 上午10:07
 */
public class ChannelTransferTest {
    public static void main(String[] args) {
        channelTransferTo();
    }

    private static long channelTransferFrom(){
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/anonymous/Documents/path", "rw");
            RandomAccessFile toFile = new RandomAccessFile("/Users/anonymous/Documents/test", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            int position = 0;
            long count = fromChannel.size();
            System.out.println(count);
            toChannel.transferFrom(fromChannel, position, count);

            fromChannel.close();
            toChannel.close();
            fromFile.close();
            toFile.close();
            return count;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    private static long channelTransferTo(){
        try {
            RandomAccessFile fromFile = new RandomAccessFile("/Users/anonymous/Documents/path", "rw");
            RandomAccessFile toFile = new RandomAccessFile("/Users/anonymous/Documents/test", "rw");
            FileChannel fromChannel = fromFile.getChannel();
            FileChannel toChannel = toFile.getChannel();
            int position = 0;
            long count = fromChannel.size();
            System.out.println(count);
            fromChannel.transferTo(position, count, toChannel);

            fromChannel.close();
            toChannel.close();
            fromFile.close();
            toFile.close();
            return count;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
}

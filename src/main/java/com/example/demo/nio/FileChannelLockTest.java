package com.example.demo.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelLockTest {
    public static void main(String[] args) throws IOException {
        //FileOutputStream fos = new FileOutputStream("/home/ikan/文档/data");
        //FileChannel fc = fos.getChannel();
        FileInputStream fis = new FileInputStream("/home/ikan/文档/data");
        FileChannel fc = fis.getChannel();
        MappedByteBuffer buffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, 5);

        //fc.lock(10, 10, false);
        System.in.read();
    }
}

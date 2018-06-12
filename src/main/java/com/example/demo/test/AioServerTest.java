package com.example.demo.test;

import edu.princeton.cs.algs4.In;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @auther houwanfei
 * @create 2018-04-02 下午9:16
 */
public class AioServerTest {
    public static void completionHandler(){
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(
                    Paths.get("/home/ikan/文档/data1"),
                    StandardOpenOption.READ,
                    StandardOpenOption.WRITE,
                    StandardOpenOption.CREATE);
            CompletionHandler<Integer, Object> handler = new CompletionHandler<Integer, Object>() {
                @Override
                public void completed(Integer result, Object attachment) {
                    System.out.println(attachment + " completed with " + result + " bytes wirtten");
                }

                @Override
                public void failed(Throwable exc, Object attachment) {
                    System.out.println(attachment + " failed with:");
                    exc.printStackTrace();
                }
            };
            String str = "WEB-INF/etc/baofoo";
            fileChannel.write(ByteBuffer.wrap(str.getBytes()), 0, "Write operation 1", handler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void futureStyle(){
        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(Paths.get("/home/ikan/文档/data1"),
                    StandardOpenOption.READ);
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            Future<Integer> future = fileChannel.read(byteBuffer, 0);

            while (!future.isDone()){
                System.out.println(new String(byteBuffer.array(), "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        completionHandler();
        futureStyle();
    }
}

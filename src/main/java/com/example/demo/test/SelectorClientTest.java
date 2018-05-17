package com.example.demo.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @auther houwanfei
 * @create 2018-04-02 上午11:21
 */
public class SelectorClientTest {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("localhost", 5012);
        try {
            SocketChannel client = SocketChannel.open(address);
            String [] messages = new String [] {"Time goes fast.", "What now?", "Bye."};
            //String [] messages = new String [] {"Time goes fast."};
            for (String message : messages){
                ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
                client.write(buffer);
                buffer.clear();
                Thread.sleep(5000);
            }
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

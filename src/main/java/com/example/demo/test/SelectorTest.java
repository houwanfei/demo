package com.example.demo.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @auther houwanfei
 * @create 2018-04-02 上午10:51
 */
public class SelectorTest {
    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();
            ServerSocketChannel socketChannel = ServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("localhost", 5012);
            socketChannel.bind(address);
            socketChannel.configureBlocking(false);
            int ops = socketChannel.validOps();
            socketChannel.register(selector, ops, null);
            while (true){
                int numOkKeys = selector.select();
                System.out.println("number of selectkey" + numOkKeys);
                Set selectSet = selector.selectedKeys();
                Iterator ite =  selectSet.iterator();
                while (ite.hasNext()){
                    SelectionKey key = (SelectionKey) ite.next();
                    if (key.isAcceptable()){
                        SocketChannel client = socketChannel.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        System.out.println("Select new connnetion");
                    } else if (key.isReadable()){
                        SocketChannel readChannel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(256);
                        int count = readChannel.read(buffer);
                        System.out.println("read number of byte:" + count);
                        String str = new String(buffer.array()).trim();
                        System.out.println("message:" + str);
                        if (str.startsWith("Bye")){
                            readChannel.close();
                        }
                    }
                    ite.remove();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.demo.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Random;

/**
 * @auther houwanfei
 * @create 2018-06-15 下午12:18
 */
public class PipeTest {
    public static void main(String[] args) throws IOException {
        WritableByteChannel writableByteChannel = Channels.newChannel(System.out);

        Pipe pipe = Pipe.open();

        new Worker(pipe.sink()).start();
        ReadableByteChannel readableByteChannel = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate(100);

        while (readableByteChannel.read(buffer) >= 0){
            buffer.flip();
            writableByteChannel.write(buffer);
            buffer.clear();
        }
    }
}

class Worker extends Thread{
    private String [] products = {
            "No good deed goes unpunished",
            "To be, or what?",
            "No matter where you go, there you are",
            "Just say \"Yo\"",
            "My karma ran over my dogma"
    };

    WritableByteChannel writableByteChannel;

    public Worker(WritableByteChannel channel){
        this.writableByteChannel = channel;
    }

    public void run(){
        Random random = new Random();
        ByteBuffer buffer = ByteBuffer.allocate(100);
        for (int i=0; i<10; i++){
            int index = random.nextInt(products.length);
            buffer.clear();
            buffer.put(products[index].getBytes());
            buffer.put("\r\n".getBytes());
            buffer.flip();
            try {
                writableByteChannel.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

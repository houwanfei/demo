package com.example.demo.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.SSLException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import static edu.princeton.cs.algs4.StdIn.readLine;

public class DiscardClient {
    static final boolean SSL = System.getProperty("ssl") != null;
    static final String HOST = System.getProperty("host", "127.0.0.1");
    static final Integer PORT = Integer.parseInt(System.getProperty("port", "8080"));
    static final Integer SIZE = Integer.parseInt(System.getProperty("size", "256"));

    public static void main(String[] args) throws Exception {
        SslContext sslContext;
        if (SSL){
            sslContext = SslContextBuilder.forClient()
                    .trustManager(InsecureTrustManagerFactory.INSTANCE).build();
        } else {
            sslContext = null;
        }

        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline p = socketChannel.pipeline();
                            if (sslContext != null) {
                                p.addLast(sslContext.newHandler(socketChannel.alloc(), HOST, PORT));
                            }
                            p.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                            p.addLast(new StringDecoder());
                            p.addLast(new StringEncoder());
                            p.addLast(new PrintClientHandler());
                        }
                    });

            Channel channel = bootstrap.connect(HOST, PORT).sync().channel();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            for (; ;){
                Thread.sleep(5000);
                String s = reader.readLine();
                channel.writeAndFlush( s+ "\r\n");
            }
        } finally {
            group.shutdownGracefully();
        }
    }
}

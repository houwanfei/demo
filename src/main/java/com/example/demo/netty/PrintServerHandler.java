package com.example.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class PrintServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf in = (ByteBuf)msg;
        System.out.println("printHandler:" + in.toString(CharsetUtil.UTF_8));
        ctx.writeAndFlush("hello sb");
        //ctx.fireChannelRead(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable canse){
        canse.printStackTrace();
        ctx.close();
    }
}

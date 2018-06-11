package com.example.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

public class PrintClientHandler extends SimpleChannelInboundHandler<String>{
    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf in = (ByteBuf) msg;
        System.out.println(in.toString(CharsetUtil.UTF_8));
    }*/

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        System.err.println(s);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable canse){
        canse.printStackTrace();
        ctx.close();
    }
}

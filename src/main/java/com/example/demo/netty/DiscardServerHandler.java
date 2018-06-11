package com.example.demo.netty;

import com.alibaba.druid.sql.visitor.functions.Char;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    /*@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ((ByteBuf)msg).release();
    }*/
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
        ByteBuf in = (ByteBuf)msg;
        try {
            /*while (in.isReadable()) {
                System.out.println(in.readByte());
                System.out.flush();
            }*/
            System.out.println(in.toString(CharsetUtil.UTF_8));
            ctx.fireChannelRead(msg);
        } finally {
            //ReferenceCountUtil.release(msg);
        }
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable canse){
        canse.printStackTrace();
        ctx.close();
    }
}

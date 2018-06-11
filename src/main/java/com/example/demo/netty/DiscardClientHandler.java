package com.example.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class DiscardClientHandler extends SimpleChannelInboundHandler<Object>{
    private ByteBuf content;
    private ChannelHandlerContext ctx;

    public void channelActive(ChannelHandlerContext ctx){
        this.ctx = ctx;
        content = ctx.alloc().directBuffer(DiscardClient.SIZE).writeZero(DiscardClient.SIZE);
        generateTraffic();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }

    private void generateTraffic(){
        ctx.writeAndFlush(content.retainedDuplicate()).addListener(trafficGenerator);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx){
        content.release();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable canse){
        canse.printStackTrace();
        ctx.close();
    }

    private final ChannelFutureListener trafficGenerator = new ChannelFutureListener() {
        @Override
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()){
                generateTraffic();
            } else {
                channelFuture.cause().printStackTrace();
                channelFuture.channel().close();
            }
        }
    };
}

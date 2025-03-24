package com.breeze.sample.nettydemo.netty.server.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther: liubiao
 * @date: 2025-03-24
 */
@Slf4j
public class OutHandle1 extends ChannelOutboundHandlerAdapter {


    @Override
    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
        log.info("OutHandle1...");
        ctx.writeAndFlush(msg);
    }
}

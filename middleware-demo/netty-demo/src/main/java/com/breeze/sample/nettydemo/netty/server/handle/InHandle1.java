package com.breeze.sample.nettydemo.netty.server.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

/**
 * @auther: liubiao
 * @date: 2025-03-24
 */
@Slf4j
public class InHandle1   extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("InHandle1 ... :{}"  );
//        super.channelRead(ctx, msg);
        ctx.fireChannelRead(msg);
//        ctx.writeAndFlush(msg);

    }
}

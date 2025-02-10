package com.breeze.sample.seata.orderservice;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @auther: liubiao
 * @date: 2024-12-25
 */
@Slf4j
public class NettyClientTest {

    public static void main(String[] args) throws InterruptedException {
        ChannelFuture channelFuture = new NettyClientTest().test();

        log.info("启动结束。。。");

        while (true){
            Thread.sleep(2000);
            String mes = "时间"+ LocalDateTime.now();
            log.info("发送消息：{}",mes);
            channelFuture.channel().writeAndFlush(mes);
        }
    }

    public ChannelFuture test() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup eventExecutors = new NioEventLoopGroup();
        bootstrap.group(eventExecutors)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    public void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new IdleStateHandler(0, 0, 5, TimeUnit.SECONDS));
                        ch.pipeline().addLast(new NettyClientHandler());
                    }
                })
                .option(ChannelOption.SO_KEEPALIVE, true);

        return bootstrap.connect("localhost", 10330)
                .sync().channel().closeFuture();

    }

    private class NettyClientHandler extends ChannelInboundHandlerAdapter {

        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            if (evt instanceof IdleStateEvent) {
                IdleStateEvent event = (IdleStateEvent) evt;
                if (event.state() == IdleState.ALL_IDLE) {
                    log.info("已经5秒没有发送数据了");
                    ctx.writeAndFlush("HEARTBEAT");
                    log.info("发送完成");
                }
            }
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("客户端收到消息:{}", msg);
        }
    }
}



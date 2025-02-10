package com.breeze.sample.seata.orderservice;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @auther: liubiao
 * @date: 2024-12-25
 */
//@SpringBootTest
@Slf4j
public class NettyTest {

    //    @Test
    public static void main(String[] args) throws InterruptedException {
        new NettyTest().test();

    }

    public void test() throws InterruptedException {

        //启动一个netty 服务
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        try {


            Bootstrap nettyServerBootstrap = new Bootstrap();
            nettyServerBootstrap.group(bossGroup)
                    .channel(NioSocketChannel.class)
                .handler(new NettySampleHandler() )
                    .option(ChannelOption.SO_KEEPALIVE, true)
            /*        .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new IdleStateHandler(5, 0, 0, TimeUnit.SECONDS));
                            ch.pipeline().addLast(new ServerHeartHandler());
                        }

                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            log.info("收到心跳.channelRead.{}", msg);
                        }
                    })
                    .childOption(ChannelOption.SO_KEEPALIVE, true)*/
            ;


            //绑定端口，启动服务
            nettyServerBootstrap.bind(10330).sync().channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
        }
    }

    /**
     * 定义心跳处理器
     */
    private class ServerHeartHandler extends ChannelInboundHandlerAdapter {
        @Override
        public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
            if (evt instanceof IdleStateEvent) {
                IdleStateEvent event = (IdleStateEvent) evt;
                if (event.state() == IdleState.READER_IDLE) {
                    log.info("端口空闲，...");
//                    log.info("端口空闲，向客户端发送心跳...");
//                    ctx.writeAndFlush("HEARTBEAT");
                }
            }
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("收到心跳.{}", msg);
        }
    }

    /**
     * 定义数据处理器
     */
    private class NettySampleHandler extends SimpleChannelInboundHandler<DatagramPacket> {

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
            String message = datagramPacket.content().toString();
            log.info("接收消息 :" + message);
        }
    }
}

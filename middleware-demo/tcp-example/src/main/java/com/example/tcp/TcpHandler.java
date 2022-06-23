package com.example.tcp;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.DatagramPacket;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TcpHandler extends SimpleChannelInboundHandler<DatagramPacket> implements CommandLineRunner {

    public TcpHandler(){

    }

    private Integer udpPort2;
    @Override
    public void run(String... args) throws Exception {

        new Thread(() -> {
            while (true) {
                EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
                try {
                    //UDP方式使用Bootstrap
                    Bootstrap serverBootstrap = new Bootstrap();
                    serverBootstrap = serverBootstrap.group(eventLoopGroup);
                    serverBootstrap = serverBootstrap.channel(NioDatagramChannel.class);
                    serverBootstrap = serverBootstrap.option(ChannelOption.SO_BROADCAST, true);
                    //不需要太多其他的东西，直接这样就可以用
                    serverBootstrap = serverBootstrap.handler(new TcpHandler());
                    log.info("开始接收新版报文工卡消息  端口：" + udpPort2);
                    ChannelFuture f = serverBootstrap.bind(udpPort2).sync();
                    f.channel().closeFuture().sync();
                } catch (Exception e) {
                    log.error("接收新版报文工卡消息处理失败", e);
                } finally {
                    log.info("netty udp close!");
                    eventLoopGroup.shutdownGracefully();
                }
            }
        }).start();


    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {

    }
}

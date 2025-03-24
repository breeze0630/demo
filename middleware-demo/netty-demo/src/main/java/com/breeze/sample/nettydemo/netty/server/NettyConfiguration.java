package com.breeze.sample.nettydemo.netty.server;

import com.breeze.sample.nettydemo.netty.server.handle.InHandle1;
import com.breeze.sample.nettydemo.netty.server.handle.InHandle2;
import com.breeze.sample.nettydemo.netty.server.handle.OutHandle1;
import com.breeze.sample.nettydemo.netty.server.handle.OutHandle2;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolver;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * @auther: liubiao
 * @date: 2025-03-24
 */
@Configuration
@Slf4j

public class NettyConfiguration {

    @PostConstruct
    public void init(){

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG,1024)
                .childOption(ChannelOption.SO_KEEPALIVE,Boolean.TRUE)
                .childHandler(new ChannelInitializer<SocketChannel>(){
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ObjectEncoder());
                        socketChannel.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(null)));
                        socketChannel.pipeline().addLast(new InHandle1());
                        socketChannel.pipeline().addLast(new InHandle2());
                        socketChannel.pipeline().addLast(new OutHandle1());
                        socketChannel.pipeline().addLast(new OutHandle2());

                    }
                });

        try {
            ChannelFuture future = serverBootstrap.bind(10010).sync();
            future.channel().closeFuture().sync();
        }catch (Exception e){
          log.error("e:{}",e);
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }
}

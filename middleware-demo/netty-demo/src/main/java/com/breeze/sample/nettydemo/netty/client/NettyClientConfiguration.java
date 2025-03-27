package com.breeze.sample.nettydemo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
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
@Slf4j
public class NettyClientConfiguration {

    ChannelFuture channelFuture = null;

    public void send(Object obj){
        channelFuture.channel().writeAndFlush(obj);
    }

    public static void main(String[] args) {
        NettyClientConfiguration netty = new NettyClientConfiguration();
        netty.init();
        netty.send("fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费" +
                "fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费" +
                "fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费fasdfsadfsadfsadfsadfsdafsdgsdfsdgsdgfsgsdgsdgsdfgsdfgfsdgfsdgsggsdfsdagsdagfs干撒地方撒大哥水电费" +
                "");
    }
    public void init(){

        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new ObjectEncoder());
                        socketChannel.pipeline().addLast(new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.weakCachingConcurrentResolver(null)));
                        socketChannel.pipeline().addLast(new ClientHandle());
                    }
                });

        try {

            channelFuture = bootstrap.connect("127.0.0.1",10010).sync();

        }catch (Exception e){
            log.error("e:{}",e);
        }
    }
}

package com.example.tcp.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author
 * @create 2021/9/9 10:12
 */
@Slf4j
@Component
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    public static NettyServerHandler nettyServerHandler;


    @PostConstruct
    public void init() {
        nettyServerHandler = this;
        // 初使化时将已静态化的testService实例化
    }

    /**
     * 客户端连接会触发
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("连接成功...");
    }

    /**
     * 客户端发消息会触发
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        log.info("服务器收到消息: {}", msg.toString());
        //此处为解析tcp参数所需要的方法！！！自定义
      /*  DataCollectorService dataCollectorService = SpringUtil.getBean(DataCollectorService.class);
        List<TsMetricForm> list = JSONUtil.toList(msg.toString(), TsMetricForm.class);
        dataCollectorService.send(list);*/
        // 将 msg.toString() 解析为对应的数据，并进行处理
        ctx.write("package received !");
        ctx.flush();
    }


    /**
     * 发生异常触发
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}


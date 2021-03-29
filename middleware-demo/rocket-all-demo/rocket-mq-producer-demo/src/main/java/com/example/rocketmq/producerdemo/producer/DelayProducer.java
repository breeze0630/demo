package com.example.rocketmq.producerdemo.producer;

import com.example.rocketmq.producerdemo.dto.MessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.impl.producer.DefaultMQProducerImpl;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * 延迟消息
 * setDelayTimeLevel
 */
@Service
@Slf4j
public class DelayProducer {

    DefaultMQProducer producer = null;

    @PostConstruct
    public void init(){
        try {
            producer = new DefaultMQProducer("msg_group_delay_demo");

            producer.setNamesrvAddr("localhost:9876");
            // 启动Producer实例
            producer.start();

            producer.setRetryTimesWhenSendAsyncFailed(0);
            log.info("DelayProducer init success");
        }catch (Exception e){
            log.error("e:{},{}","DelayProducer init failed",e);
        }

    }


    public void send(MessageDTO dto){
        try {
            // 创建消息，并指定Topic，Tag和消息体
            Message msg = new Message(dto.getTopic(),
                    dto.getTag(),
                    dto.getMsg().getBytes(RemotingHelper.DEFAULT_CHARSET));
            msg.setDelayTimeLevel(2);
            // SendCallback接收异步返回结果的回调
            producer.send(msg, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    log.info("sendResult:{}",sendResult.getMsgId());
//                        System.out.printf(" OK %s %n",
//                                sendResult.getMsgId());
                }
                @Override
                public void onException(Throwable e) {
                    System.out.printf(" Exception %s %n" , e);
                    e.printStackTrace();
                }
            });
//            }
        }catch (Exception e){

        }

    }
    /**
     * 系统停止时关闭资源
     * */
    @PreDestroy
    public void closed(){
        producer.shutdown();
    }
}

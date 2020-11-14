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

@Service
@Slf4j
public class AsyncProducer {

    DefaultMQProducer producer = null;

    @PostConstruct
    public void init(){
        try {
            producer = new DefaultMQProducer("msg_group_async_demo");

            producer.setNamesrvAddr("localhost:9876");
            // 启动Producer实例
            producer.start();
            /**
             * 线程池可以单独设置
             * TODO 不建议调整线程数，可根据实际业务场景调整队列数
             * */
            //可以设置 线程池，默认使用的规格为 队列：2000，核心线程数:1，最大线程数：1,
            DefaultMQProducerImpl transactionMQProducer = producer.getDefaultMQProducerImpl();
            LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue(2000);
            ExecutorService executorService = new ThreadPoolExecutor(5, 10, 60000L, TimeUnit.MILLISECONDS, blockingQueue);
            transactionMQProducer.getmQClientFactory().getMQClientAPIImpl().getRemotingClient().setCallbackExecutor(executorService);


            producer.setRetryTimesWhenSendAsyncFailed(0);
            log.info("AsyncProducer init success");
        }catch (Exception e){
            log.error("e:{},{}","AsyncProducer init failed",e);
        }

    }

    public void send(MessageDTO dto){
        try {
//            int messageCount = 100;
            // 根据消息数量实例化倒计时计算器
//            final CountDownLatch2 countDownLatch = new CountDownLatch2(messageCount);
//            for (int i = 0; i < messageCount; i++) {
//                final int index = i;
                // 创建消息，并指定Topic，Tag和消息体
                Message msg = new Message(dto.getTopic(),
                        dto.getTag(),
                        dto.getMsg().getBytes(RemotingHelper.DEFAULT_CHARSET));
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

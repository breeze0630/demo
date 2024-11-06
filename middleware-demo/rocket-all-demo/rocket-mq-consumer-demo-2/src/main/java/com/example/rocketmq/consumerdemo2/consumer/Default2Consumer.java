//package com.example.rocketmq.consumerdemo.consumer;
//
//import com.example.rocketmq.consumerdemo.service.dao.BizLogMapper;
//import com.example.rocketmq.consumerdemo.service.entity.BizLog;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
//import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
//import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;
//import javax.annotation.Resource;
//import java.util.List;
//
//@Service
//@Slf4j
//public class Default2Consumer {
//
//    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("msg_group_default_consumer1");
//
//    @Resource
//    private BizLogMapper bizLogMapper;
//    @PostConstruct
//    public void init(){
//        try {
//            consumer.setNamesrvAddr("localhost:9876");
//            consumer.subscribe("topic1", "*");
//            consumer.registerMessageListener(new MessageListenerConcurrently() {
//
//                @Override
//                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs,
//                                                                ConsumeConcurrentlyContext context) {
//                    long start = System.currentTimeMillis();
//                   log.info("{} Receive 2 New Messages: {}", Thread.currentThread().getName(), msgs);
//                   /* msgs.forEach( k->{
//                        if(k.getTopic().equals("topic2")){
//                            throw new RuntimeException();
//                        }
//                    });*/
//                    msgs.stream().forEach(k->{
//                        BizLog bizLog = BizLog.builder().address("127.0.0.1").context(new String(k.getBody())).build();
//                        bizLogMapper.insert(bizLog);
//                    });
//                    long end = System.currentTimeMillis();
//                    log.info("执行时间: {}ms" ,end-start);
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
//            });
//
//            consumer.start();
//            log.info("DefaultConsumer init success..");
//        }catch (Exception E){
//            log.error("DefaultConsumer init failed....");
//        }
//
//    }
//
//    @PreDestroy
//    public void close(){
//        consumer.shutdown();
//    }
//
//}

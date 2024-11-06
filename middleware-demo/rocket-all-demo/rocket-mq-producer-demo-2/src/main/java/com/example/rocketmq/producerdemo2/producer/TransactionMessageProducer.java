//package com.example.rocketmq.producerdemo.producer;
//
//import com.alibaba.fastjson.JSON;
//import com.example.rocketmq.producerdemo.dto.MessageDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.producer.LocalTransactionState;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.client.producer.TransactionCheckListener;
//import org.apache.rocketmq.client.producer.TransactionMQProducer;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.common.message.MessageExt;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//
//@Slf4j
//@Service
//public class TransactionMessageProducer {
//
//    TransactionMQProducer transactionMQProducer = null;
//
//    @PostConstruct
//    public void init(){
//        try {
//            transactionMQProducer = new TransactionMQProducer("msg_group_transaction_demo");
//
//            transactionMQProducer.setNamesrvAddr("localhost:9876");
//
//            //事务回查最小并发数
//            transactionMQProducer.setCheckThreadPoolMinSize(5);
//            //事务回查最大并发数
//            transactionMQProducer.setCheckThreadPoolMaxSize(20);
//            //队列数
//            transactionMQProducer.setCheckRequestHoldMax(2000);
//
//            // 启动Producer实例
//            transactionMQProducer.start();
//            transactionMQProducer.setTransactionCheckListener(new TransactionCheckListener() {
//
//                @Override
//
//                public LocalTransactionState checkLocalTransactionState(MessageExt messageExt) {
//
//                    System.out.println("state --" + new String(messageExt.getBody()));
//
//                    return LocalTransactionState.COMMIT_MESSAGE;
//
//                }
//
//            });
//
//            log.info("TransactionMessageProducer init success");
//        }catch (Exception e){
//            log.error("e:{},{}","TransactionMessageProducer init failed",e);
//        }
//
//    }
//
//
//    public void send(MessageDTO dto){
//        try {
//            // 创建消息，并指定Topic，Tag和消息体
//            Message msg = new Message(dto.getTopic(),
//                    dto.getTag(),
//                    dto.getMsg().getBytes(RemotingHelper.DEFAULT_CHARSET));
//            TransactionExecuterImpl transactionExecuter = new TransactionExecuterImpl();
//
//            SendResult sendResult = transactionMQProducer.sendMessageInTransaction(msg, transactionExecuter, "tq");
//            log.info(JSON.toJSONString(sendResult));
//        }catch (Exception e){
//            log.error("e:{},{}","TransactionMessageProducer send",e);
//        }
//
//    }
//
//}

//package com.example.rocketmq.producerdemo.producer;
//
//import com.alibaba.fastjson.JSON;
//import com.example.rocketmq.producerdemo.dto.MessageDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.exception.MQBrokerException;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.remoting.common.RemotingHelper;
//import org.apache.rocketmq.remoting.exception.RemotingException;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//import java.io.UnsupportedEncodingException;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * 同步消息发送器
// *
// * */
//@Service
//@Slf4j
//public class SyncProducer {
//
//    DefaultMQProducer producer = null;
//
//    @PostConstruct
//    public void init() throws Exception{
//        producer = new DefaultMQProducer("msg_group_demo");
//        producer.setNamesrvAddr("localhost:9876");
//
//
//        producer.start();
//
//    }
//
//
//    public void sendMsg(MessageDTO dto) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
//            Message msg = new Message(dto.getTopic() , dto.getTag() ,   dto.getMsg().getBytes(RemotingHelper.DEFAULT_CHARSET));
//        msg.setDelayTimeLevel(2);
//        SendResult sendResult = producer.send(msg);
//            log.info("sendResult:{}", JSON.toJSONString(sendResult));
//    }
//
//    public void sendMsgQueue(List<MessageDTO> dtoList) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {
//
//        List<Message> messages = dtoList.stream().map( dto -> {
//            try {
//                Message msg = new Message(dto.getTopic() , dto.getTag() ,dto.getMsg().getBytes(RemotingHelper.DEFAULT_CHARSET));
////                msg.setDelayTimeLevel(2);
//                return msg;
//            }catch (UnsupportedEncodingException e){
//
//            }
//            return null;
//        }).collect(Collectors.toList());
//        SendResult sendResult = producer.send(messages);
//        log.info("sendResult:{}", JSON.toJSONString(sendResult));
//    }
////    @PreDestroy
////    public void close(){
////        producer.shutdown();
////    }
//
//}

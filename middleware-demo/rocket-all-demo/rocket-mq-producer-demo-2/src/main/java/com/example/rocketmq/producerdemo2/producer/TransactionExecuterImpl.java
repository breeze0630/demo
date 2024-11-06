//package com.example.rocketmq.producerdemo.producer;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.client.producer.LocalTransactionExecuter;
//import org.apache.rocketmq.client.producer.LocalTransactionState;
//import org.apache.rocketmq.common.message.Message;
//
//@Slf4j
//public class TransactionExecuterImpl implements LocalTransactionExecuter {
//
//    @Override
//    public LocalTransactionState executeLocalTransactionBranch(Message msg, Object arg) {
//        log.info("msg={}" , new String(msg.getBody()));
//
//        log.info("arg = {}",arg);
//
//        String tag = msg.getTags();
//
//        if (tag.equals("Transaction1")){
//
//            //这里有一个分阶段提交的概念
//
//            log.info("这里是处理业务逻辑，失败情况下进行ROLLBACK");
//
//            return LocalTransactionState.ROLLBACK_MESSAGE;
//
//        }
//
//        return LocalTransactionState.COMMIT_MESSAGE;
//    }
//}

package com.breeze.sample.seata.stockservice.filter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.seata.tm.api.BaseTransaction;
import org.apache.seata.tm.api.FailureHandler;
import org.springframework.stereotype.Component;

/**
 * @auther: liubiao
 * @date: 2024-12-13
 */
@Component(value = "failureHandler")
@Slf4j
public class CustomFailureHandler implements FailureHandler {

    @Override
    public void onBeginFailure(BaseTransaction tx, Throwable cause) {
      log.info("onBeginFailure:{}",tx);
    }

    @Override
    public void onCommitFailure(BaseTransaction tx, Throwable cause) {

    }

    @Override
    public void onRollbackFailure(BaseTransaction tx, Throwable originalException) {
        log.info("onRollbackFailure:{}", JSON.toJSONString(tx));
    }

    @Override
    public void onRollbacking(BaseTransaction tx, Throwable originalException) {
        log.info("onRollbacking:{}", JSON.toJSONString(tx));

    }
}

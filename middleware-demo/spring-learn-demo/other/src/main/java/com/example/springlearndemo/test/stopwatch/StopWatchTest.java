package com.example.springlearndemo.test.stopwatch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

/**
 * @description:
 * @auther: liubiao
 * @date: 2024-05-08
 */
@Slf4j
public class StopWatchTest {

    public static void main(String[] args) throws Exception {

        StopWatch stopWatch = new StopWatch();

        stopWatch.start("测试1");

        Thread.sleep(10);
        stopWatch.stop();
        log.info("\r\n" + stopWatch.prettyPrint());

    }
}

package com.example.springlearndemo.aop.overview;

/**
 * 代理实现
 * */
public class ProxyEchoService implements EchoService{

    private final EchoService echoService;

    public ProxyEchoService(EchoService echoService) {
        this.echoService = echoService;
    }

    @Override
    public String echo(String message) {

        long startTime = System.currentTimeMillis();
        String result = echoService.echo(message);
        long costTime = System.currentTimeMillis()- startTime;
        System.out.println("echo 方法执行时间: " + costTime + " ms.");
        return result;
    }
}

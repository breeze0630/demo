package com.example.springlearndemo.aop.overview;

/**
 * 静态代理示例
 * */
public class StaticProxyDemo {

    public static void main(String[] args) throws Exception {
        EchoService echoService = new ProxyEchoService(new DefaultEchoService());
        echoService.echo("Hello,World!");
    }
}

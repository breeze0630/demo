package com.example.springlearndemo.aop.overview;

/**
 * 默认实现 {@link EchoService}
 *
 */
public class DefaultEchoService implements EchoService{

    @Override
    public String echo(String message) {
        String result  = "[ECHO] "+ message;
        System.out.println(result);
        return result;
    }
}

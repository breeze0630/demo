package com.example.design.observer.subject;

import com.example.design.observer.server.Observer;

/**
 * @
 * @Description 这是被观察者接口
 * @Date: 2020/5/26 22:58
 * @Create by external_ll@163.com
 **/
public interface Subject {

    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyAllObserver();
}

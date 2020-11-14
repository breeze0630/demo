package com.example.design.observer.server;

import com.example.design.observer.subject.WeatherDataSubject;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/26 23:09
 * @Create by external_ll@163.com
 **/
public class CurrentWeatherBoard implements Observer,DisplayElement {

    private WeatherDataSubject weatherDataSubject;

    private float temperature;
    private float humidity;
    private float pressure;


    public CurrentWeatherBoard(WeatherDataSubject weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        this.weatherDataSubject.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.printf("当前温度为:%s\n",this.temperature);
        System.out.printf("当前湿度为:%s\n",this.humidity);
        System.out.printf("当前气压为:%s\n",this.pressure);
    }

    @Override
    public void update() {

        display();
    }
}

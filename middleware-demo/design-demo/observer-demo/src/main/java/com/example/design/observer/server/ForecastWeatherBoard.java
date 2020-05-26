package com.example.design.observer.server;

import com.example.design.observer.subject.WeatherDataSubject;

import java.util.List;

/**
 * @
 * @Description
 * @Date: 2020/5/26 23:24
 * @Create by external_ll@163.com
 **/
public class ForecastWeatherBoard implements Observer,DisplayElement{
    private WeatherDataSubject weatherDataSubject;

    private List<Float> forecastTemperatures;

    public ForecastWeatherBoard(WeatherDataSubject weatherDataSubject) {
        this.weatherDataSubject = weatherDataSubject;
        this.weatherDataSubject.registerObserver(this);
    }

    @Override
    public void display() {
        int index = 0;
        for(Float f : forecastTemperatures){
            System.out.printf("第%s天的温度为:%s\n",(index++),f);
        }
    }

    @Override
    public void update() {

    }
}

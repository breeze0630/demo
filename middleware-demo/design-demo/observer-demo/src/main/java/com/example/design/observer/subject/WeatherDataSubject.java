package com.example.design.observer.subject;

import com.example.design.observer.server.Observer;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @
 * @Description TODO
 * @Date: 2020/5/26 23:05
 * @Create by external_ll@163.com
 **/
public class WeatherDataSubject  implements Subject{


    private List<Observer> observerList ;
    /**温度*/
    private float temperature;
    /**湿度*/
    private float humidity;
    /**气压*/
    private float pressure;
    /**未来几天的温度*/
    private List<Float> forecastTemperatures;

    public WeatherDataSubject() {
        this.observerList = new ArrayList<>();
    }

    public void setMeasurements(float temperature, float humidity,
                                float pressure, List<Float> forecastTemperatures) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        this.forecastTemperatures = forecastTemperatures;
        notifyAllObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        if(observer!=null) this.observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if(observer!=null) this.observerList.remove(observer);
    }

    @Override
    public void notifyAllObserver() {
        if(CollectionUtils.isEmpty(this.observerList)){
            return;
        }
        for (Observer observer : this.observerList){
            observer.update();
        }
    }
}

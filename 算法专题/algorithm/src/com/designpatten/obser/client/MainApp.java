package com.designpatten.obser.client;

import com.designpatten.obser.display.CurrentConditionsDisplay;
import com.designpatten.obser.subject.Weather;

/**
 * 基本流程：
 *  先创建一个类，然后将类自己注册到观察者中
 *  然后修改观察者的值，调用
 */
public class MainApp {
    public static void main(String[] args) {
        Weather weather = new Weather();
        CurrentConditionsDisplay display1 = new CurrentConditionsDisplay(weather);
        CurrentConditionsDisplay display2 = new CurrentConditionsDisplay(weather);
        CurrentConditionsDisplay display3 = new CurrentConditionsDisplay(weather);
        CurrentConditionsDisplay display4 = new CurrentConditionsDisplay(weather);
        CurrentConditionsDisplay display5 = new CurrentConditionsDisplay(weather);

        weather.setNums(1,1,11);
    }
}


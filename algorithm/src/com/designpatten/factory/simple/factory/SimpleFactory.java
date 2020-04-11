package com.designpatten.factory.simple.factory;

import com.designpatten.factory.simple.pazzia.CheesePizza;
import com.designpatten.factory.simple.pazzia.Pazza;

public class SimpleFactory {

    public static Pazza getPizza(String name){
        Pazza pazza = null;
        if (name.equals("a")){
            pazza = new CheesePizza();
            pazza.setName(name);
        }else {
            //……
        }
        return pazza;
    }

}

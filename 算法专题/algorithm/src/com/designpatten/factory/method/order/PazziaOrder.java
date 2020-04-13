package com.designpatten.factory.method.order;

import com.designpatten.factory.method.pazzia.Pazza;

import java.util.Scanner;

public abstract class PazziaOrder {
    private String name;

    public PazziaOrder(){
        pazziaOrder();
    }

    public void pazziaOrder(){
//        String name = getType();
        Pazza pazza ;
        while (true){
            name = getType();
            //获取工厂
            pazza = getPazza(name);
            pazza.prepar();
            pazza.bake();
            pazza.cut();
            pazza.box();
        }
    }

    public abstract Pazza getPazza(String name);

    private String getType() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

package com.designpatten.factory.none.order;

import com.designpatten.factory.none.pazzia.CheesePizza;
import com.designpatten.factory.none.pazzia.Pazza;

import java.util.Scanner;

public class PazziaOrder {
    private String name;

    public PazziaOrder(){
        pazziaOrder();
    }

    public void pazziaOrder(){
//        String name = getType();
        Pazza pazza ;
        while (true){
            name = getType();
            if (name.equals("a")){
                pazza = new CheesePizza();
                pazza.setName(name);
            }else {
                break;
            }
            pazza.prepar();
            pazza.bake();
            pazza.cut();
            pazza.box();
        }
    }

    private String getType() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}

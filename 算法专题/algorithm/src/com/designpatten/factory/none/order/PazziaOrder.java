package com.designpatten.factory.none.order;

import com.designpatten.factory.none.pazzia.NaiyouPizza;
import com.designpatten.factory.none.pazzia.Pazza;
import com.designpatten.factory.none.pazzia.TianNaiPizza;

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
            /**
             * 存在的问题
             *  1.每次增加pizza就需要在这里修改，否则无法满足要求
             *  2.优化：
             *    将创建交给一个统一类取完成，这里只调用方法。
             */
            if (name.equals("naiyou")){
                pazza = new NaiyouPizza();
            }else if(name.equals("tiannai")) {
                pazza = new TianNaiPizza();
            }else {break;
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

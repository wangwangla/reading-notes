package com.designpatten.factory.none.pazzia;

public class TianNaiPizza extends Pazza {
    @Override
    public void prepar() {
        System.out.println(" 给TianNai披萨准备原材料！");
        setName("TianNai");
    }
}

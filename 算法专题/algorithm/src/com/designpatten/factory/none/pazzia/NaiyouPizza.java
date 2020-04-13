package com.designpatten.factory.none.pazzia;

/**
 * 不同口味的
 */
public class NaiyouPizza extends Pazza {
    @Override
    public void prepar() {
        System.out.println(" 给naiyou披萨准备原材料！");
        setName("naiyou");
    }
}

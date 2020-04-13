package com.designpatten.factory.simple.pazzia;

/**
 * 不同的奶酪
 */
public class NaiLaoPizza extends Pazza {
    @Override
    public void prepar() {
        System.out.println(" 给制作奶酪准备原材料");
    }
}

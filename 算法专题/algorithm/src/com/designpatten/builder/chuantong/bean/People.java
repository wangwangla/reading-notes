package com.designpatten.builder.chuantong.bean;

import com.designpatten.builder.chuantong.abst.God;

public class People extends God {

    @Override
    public void face() {
        System.out.println("face");
    }

    @Override
    public void eye() {
        System.out.println("eye");
    }

    @Override
    public void hand() {
        System.out.println("hand");
    }

    @Override
    public void foot() {
        System.out.println("foot");
    }
}

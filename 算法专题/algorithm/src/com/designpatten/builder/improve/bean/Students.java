package com.designpatten.builder.improve.bean;

import com.designpatten.builder.improve.abst.God;

public class Students extends God {
    @Override
    public void face() {
        System.out.println("student face");
    }

    @Override
    public void eye() {
        System.out.println("student eye");
    }

    @Override
    public void hand() {
        System.out.println("student hand");
    }

    @Override
    public void foot() {
        System.out.println("student foot");
    }
}

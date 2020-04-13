package com.designpatten.factory.simple.pazzia;

/**
 * pizza的制作大同小异，所以在pizza里面有许多的方法是一样的
 */
public abstract class Pazza {

    private String name;

    public abstract void prepar();

    public void bake(){
        System.out.println(name+ " bake");
    }

    public void cut(){
        System.out.println(name+" cut");
    }

    public void box(){
        System.out.println(name+" boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.designpatten.factory.method.pazzia;

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

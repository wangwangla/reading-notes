package com.exception;

public class Demo {
    private int a = 0;
    Demo(){
        throw new RuntimeException("");
    }

    public int getA() {
        return a;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getA());
    }
}

package com.designpatten.yuanxing.depth.bean;

public class MyString implements Cloneable{
    private String str;
    public MyString(String str){
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "MyString{" +
                "str='" + str + '\'' +
                '}';
    }

    @Override
    public MyString clone() throws CloneNotSupportedException {
        MyString string = (MyString) super.clone();
        return string;
    }
}

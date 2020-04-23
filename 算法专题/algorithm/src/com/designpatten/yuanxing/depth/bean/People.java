package com.designpatten.yuanxing.depth.bean;

//如果需要该类 可以实现克隆的，就需要实现这个接口，然后实现相应的方法
public class People implements Cloneable{
    private String name;
    private int age;
    private MyString string;

    public MyString getString() {
        return string;
    }

    public void setString(MyString string) {
        this.string = string;
    }

    public People(String name, int age, MyString string) {
        this.name = name;
        this.string = string;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", string=" + string +
                '}';
    }

    @Override
    public People clone() throws CloneNotSupportedException {
        People people = null;
        try {
            people = (People) super.clone();
            string = string.clone();
        }catch (Exception e){}
        return people;
    }
}

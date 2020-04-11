package com.designpatten.yuanze.dimite;

import java.util.*;
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        PeopleManager manager = new PeopleManager();
        List<People> add = manager.add();
    }
}

class People{
    private String name;
    private int age;

    public People(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PeopleManager{
    private List<People> list = new ArrayList<>();
    public List<People> add(){
        for (int i = 0; i < 10; i++) {
            list.add(new People("kw"+i,12));
        }
        return list;
    }

    public void display(){
        for (People people : list) {
            System.out.println(people.toString());
        }
    }
}
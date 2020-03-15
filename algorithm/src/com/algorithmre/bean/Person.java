package com.algorithmre.bean;

import java.util.Comparator;

public class Person implements Comparator<Person> {
    private String name;
    private int age;

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

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compare(Person o1, Person o2) {
        return o1.age - o2.age;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

package com.algorithmre;

import com.algorithm.symbol.SymbolTable;
import com.algorithmre.bean.Person;
import com.algorithmre.bean.Student;

import java.util.Comparator;

public class ComparableTest{
    public static void main(String[] args) {
        Student stu1 = new Student("kw",1);
        Student stu2 = new Student("kw",2);
        System.out.println("输出："+stu1.compareTo(stu2));
        Person person = new Person("kw",4);
        Person person1 = new Person("kw",5);
        System.out.println(person.compare(person,person1));
    }
}

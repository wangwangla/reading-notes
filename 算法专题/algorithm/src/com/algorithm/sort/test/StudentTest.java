package com.algorithm.sort.test;

import com.algorithm.sort.Student;

class StudentTest {
    public static void main(String[] args) {
        Student stu1 = new Student("张三",12);
        Student stu2 = new Student("张三",14);
        Comparable max = getMax(stu1,stu2);
        System.out.printf("输出最大："+max);
    }
    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);
        if (result <= 0){
            return c2;
        }else {
            return c1;
        }
    }
}
package kw.test.demo;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.addElement(new Integer(3));
        vector.addElement(new String("SS2"));
        for (int i = 0; i < vector.size(); i++) {
            System.out.println(vector.elementAt(i));
        }

        vector.addElement(new Dog());
        vector.addElement(new Cat());

        System.out.println(vector);
    }
}

class  Dog{
    int x = 0;

    @Override
    public String toString() {
        return "Dog{" +
                "x=" + x +
                '}';
    }
}

class Cat{
    int c = 0;

    @Override
    public String toString() {
        return "Cat{" +
                "c=" + c +
                '}';
    }
}
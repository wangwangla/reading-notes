package com.fanxing.classandconstruction;

import java.lang.reflect.Constructor;

public class PeopleTest {
    public static void main(String[] args) throws Exception {
        Class<People> peopleClass = People.class;
        Constructor<People> constructor = peopleClass.getConstructor();
        People people = constructor.newInstance();

    }
}

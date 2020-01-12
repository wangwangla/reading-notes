package test.demo.note01.client;

import kw.kw.test.demo.Demo03_01;
import kw.kw.test.demo.Demo03_02;
import kw.kw.test.demo.interfaces.FatherDemo03;

public class Demo03 {
    public static void main(String[] args) {

    }

    public static FatherDemo03 getInstance(){
        return new Demo03_01();
    }

    public static FatherDemo03 getInstance1(){
        return new Demo03_02();
    }

}

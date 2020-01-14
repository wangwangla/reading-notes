package test.demo.note03;

import javax.swing.*;

public class Demo02 {
    public static int count = 0;
    public static final Demo02 instance= new Demo02();
    private Demo02(){
        System.out.println("==="+ count);
        count++;
        if (count ==2){
            throw new RuntimeException();
        }
    }
    public static Demo02 getInstance(){
        return instance;
    }
}

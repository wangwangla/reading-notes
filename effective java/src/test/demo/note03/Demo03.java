package test.demo.note03;

import java.io.Serializable;

public class Demo03 implements Serializable {
    public transient static int count = 0;
    public transient static final Demo03 instance= new Demo03();
    private Demo03(){
    }
    public static Demo03 getInstance(){
        return instance;
    }

    private Object readResolve(){
        return instance;
    }
}

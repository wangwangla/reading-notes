package com.inner;

/**
 * 1.定义在方法中的内部类
 */
public class Demo04 {
    /**
     * Method是Father的一部分，return的时候是向上转型，这个不是说执行完成这个方法，他就没什么可以使用了
     *
     * @return
     */
    public Father getIntance(){
        final class DemoMethod implements Father{

        }
        return new DemoMethod();
    }

    public void test(){
        class De{
           private int tr;

            public int getTr() {
                return tr;
            }
        }
        De de = new De();
        de.getTr();
    }
}













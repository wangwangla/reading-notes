package com.designpatten.single;

public class SingleTwo {
}

class Singletono{
    private static Singletono instance;

    public Singletono(){}

    //提供一个静态的共有方法，才会床技安一个instance

    /**
     * 多个线程就会出现线程安全的问题
     * @return
     */
    public static Singletono getInstance() {
        if (instance == null){
            instance = new Singletono();
        }
        return instance;
    }

    //改进

    /**
     * 这种方式有问题：每次都需要执行一次锁，但是只需要在第一次就可以了
     * @return
     */
    public static synchronized Singletono getInstance1(){
        if (instance == null){
            instance = new Singletono();
        }
        return instance;
    }

    public static synchronized Singletono getInstance2(){
        if (instance == null){
            //只有进入到if就会创建对象
                synchronized (SingleTwo.class){
                //到底这个位置
                instance = new Singletono();
            }
        }
        return instance;
    }

    /**
     * 解决了懒加载的问题   解决了线程安全的问题
     * @return
     */
    public static synchronized Singletono getInstance3(){
        if (instance == null){
            //只有进入到if就会创建对象
            synchronized (SingleTwo.class){
                //到底这个位置
                if (instance == null) {
                    instance = new Singletono();
                }
            }
        }
        return instance;
    }


}

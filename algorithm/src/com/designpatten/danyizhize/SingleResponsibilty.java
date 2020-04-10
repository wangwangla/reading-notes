package com.designpatten.danyizhize;

public class SingleResponsibilty {
    public static void main(String[] args) {

    }
}

/**
 * 创建一个类，类中有运行的方式
 *
 * 存在问题：
 *   - 传入一个交通工具，然后执行一个run方法，如果天上飞的，那就会有问题
 *   - 解决方法
 *      按照交通工具的不同进行分类即可。
 */

/**
 * version one
 */
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + " is run on the road");
    }
}

/**
 * version two
 */
class RoadVehice{
    public void run(String vehicle){
        System.out.println(vehicle + " is run on the road");
    }
}

class SkyVehice{
    public void run(String vehicle){
        System.out.println(vehicle + " is fly on the sky");
    }
}

/**
 * version three
 *
 * 1.对于服务端代码是做了一定的修改
 * 2.违背了单一职责（类） 方法上仍然遵守
 */
class VehicleVersionThree{
    public void roadRun(String vehicle){
        System.out.println(vehicle + " is run on the road");
    }

    public void skyFly(String vehicle){
        System.out.println(vehicle + " is fly on the sky");
    }
}

/**
 * 总结：
 *  - 降低了类的复杂度
 *  - 提高了类的可读性，可维护性
 *  - 降低了变更引起的风险
 *  - 一般的，遵循单一职责，
 */
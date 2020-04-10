package com.designpatten.jiekougeli;





/**
 *
 * 总结： 可以看出它们并不会将所有的方法都依赖，仅仅只依赖一部分
 * 解决方法：将接口进行拆分
 */

/**
 * 拆分:
 *  找出公共方法的抽象类
 */
interface FatherVersionTwo {
    void methodOne();
}
interface FatherVersionTwo1 extends FatherVersionTwo{
    void methodFour();
}
interface FatherVersionTwo2 extends FatherVersionTwo{
    void methodTwo();
    void methodThree();
}

class SonOneVesionTwo implements FatherVersionTwo,FatherVersionTwo1{

    @Override
    public void methodOne() {

    }

    @Override
    public void methodFour() {

    }
}

class SonTwoVesionTwo implements FatherVersionTwo,FatherVersionTwo2{

    @Override
    public void methodOne() {

    }

    @Override
    public void methodTwo() {

    }

    @Override
    public void methodThree() {

    }
}

class SonThreeVesionTwo {
    public void methodOne(FatherVersionTwo fatherVersion){
        fatherVersion.methodOne();
    }
    public void methodThree(FatherVersionTwo2 fatherVersion){
        fatherVersion.methodThree();
    }
    public void methodTwo(FatherVersionTwo2 fatherVersion){
        fatherVersion.methodTwo();
    }
}

class SonFourVesionTwo {
    public void methodOne(FatherVersionTwo fatherVersion){
        fatherVersion.methodOne();
    }
    public void methodFour(FatherVersionTwo1 fatherVersion){
        fatherVersion.methodFour();
    }
}



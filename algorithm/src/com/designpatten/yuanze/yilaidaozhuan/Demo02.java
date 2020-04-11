package com.designpatten.yuanze.yilaidaozhuan;

import java.util.Date;

/**
 * 依赖关系
 *  - 接口方式
 */
//public class Demo02 {
//}
//
//interface  Car{
//    public void fire(FireMethod method);
//}
//
//interface FireMethod{
//    public void method();
//}
//
//class Audi implements Car{
//    @Override
//    public void fire(FireMethod method) {
//        method.method();
//    }
//}
//

public class Demo02 {
}
//
//interface  Car{
//    public void fire();
//}
//
//interface FireMethod{
//    public void method();
//}
//
//class Audi implements Car{
//    private FireMethod method;
//    public Audi(FireMethod method){
//        this.method = method;
//    }
//
//    @Override
//    public void fire() {
//        method.method();
//    }
//}

//
//interface  Car{
//    public void fire();
//}
//
//interface FireMethod{
//    public void method();
//}
//
//class Audi implements Car{
//    private FireMethod method;
//    public void setMethod(){
//        this.method = method;
//    }
//
//    @Override
//    public void fire() {
//        method.method();
//    }
//}




interface  Car{
    public void fire();

}

abstract class FireMethod{
    public abstract void method();
    public Long getTime(){
        return new Date().getTime();
    }
}

class Audi implements Car{
    private FireMethod method;
    public void setMethod(){
        this.method = method;
    }

    @Override
    public void fire() {
        method.method();
        method.getTime();
    }
}



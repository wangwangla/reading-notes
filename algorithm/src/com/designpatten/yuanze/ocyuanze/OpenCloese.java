package com.designpatten.yuanze.ocyuanze;

public class OpenCloese {
}

abstract class Shap{
    public int shapType = 0;
    public abstract void draw();
}

class Cir extends Shap{
    public Cir(){
        shapType = 1;
    }

    @Override
    public void draw() {

    }
}

class Seq extends Shap{
    public Seq(){
        shapType = 1;
    }

    @Override
    public void draw() {

    }
}

class Draw{
    public void draw(Shap shap){
//        if (shap.shapType==1) {
//            System.out.println("===============");
//        }else if(shap.shapType == 2){
//            System.out.println("=============");
//        }
        shap.draw();
    }
}
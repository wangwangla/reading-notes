package com.designpatten.obser.subject;

import com.designpatten.obser.oberver.Oberver;

public class Weather implements Suject {
    private int num1;
    private int num2;
    private int num3;

    @Override
    public void resi(Oberver oberver) {
        observer.add(oberver);
    }

    @Override
    public void remove(Oberver oberver) {
        observer.remove(oberver);
    }

    @Override
    public void notifyData() {
        for (Oberver o : observer) {
            o.updata(num1,num2,num3);
        }
    }

    public void onchange(){
        notifyData();
    }

    public void setNums(int num1,int num2,int num3){
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
        onchange();
    }
}

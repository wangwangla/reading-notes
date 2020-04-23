package com.designpatten.builder.improve.abst;

public abstract class God {
    public abstract void face();
    public abstract void eye();
    public abstract void hand();
    public abstract void foot();
    public void build(){
        face();
        eye();
        hand();
        foot();
    }
}

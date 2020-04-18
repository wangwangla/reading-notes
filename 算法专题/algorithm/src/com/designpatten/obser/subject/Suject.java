package com.designpatten.obser.subject;

import com.designpatten.obser.oberver.Oberver;

import java.util.ArrayList;
import java.util.List;

public interface Suject {
    List<Oberver> observer = new ArrayList<>();
    //主题维持一个关系
    public void resi(Oberver oberver);
    public void remove(Oberver oberver);
    public void notifyData();
}

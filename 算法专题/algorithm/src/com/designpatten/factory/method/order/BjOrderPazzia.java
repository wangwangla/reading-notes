package com.designpatten.factory.method.order;

import com.designpatten.factory.method.pazzia.BjPazza;
import com.designpatten.factory.method.pazzia.Pazza;

/**
 * 不同的子类地区   方法里面在分类型
 *
 * 不同的地区，使用不同的工厂
 */
public class BjOrderPazzia extends PazziaOrder {
    @Override
    public Pazza getPazza(String name) {
        Pazza pazza = null;
//        pazza = new BjPazzia();
        //这里在分口味
        pazza = new BjPazza();
        return pazza;
    }
}

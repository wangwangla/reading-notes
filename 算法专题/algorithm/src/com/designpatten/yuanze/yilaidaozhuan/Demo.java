package com.designpatten.yuanze.yilaidaozhuan;

public class Demo  {

}


class SendBookByWeixin{
    public void sendBook(){
        System.out.println("weixin send book !");
    }
}

/**
 * 如果想通过微信来获取消息，那么就需要重新写类，增加方法
 * 处理方法：使用接口（细节依赖抽象）
 */
class  People {
    public void receiveBook(SendBookByWeixin s){
        s.sendBook();
    }
}


interface IReader{
    public void sendBook();
}

class SendBookByWeiBo implements IReader{
    @Override
    public void sendBook() {

    }
}


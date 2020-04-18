package com.test;

import com.designpatten.obser.oberver.Oberver;

public class Demo05 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        while (true){
            synchronized (Demo05.class) {
                if (myThread.isFlag()){
                     System.out.println("change flag!");
                }
            }
//            if (myThread.isFlag()){
//                System.out.println("change flag!");
//            }
        }
    }
}

class MyThread extends Thread{
    private boolean flag = false;
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            flag = true;
        }catch (Exception e){

        }
        System.out.println("set flag : " + true);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
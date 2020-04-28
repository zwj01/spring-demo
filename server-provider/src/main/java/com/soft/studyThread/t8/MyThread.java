package com.soft.studyThread.t8;

/**
 * @author ZWJ
 * @date 2019/8/28 13:51
 * @Version 1.0
 **/
public class MyThread extends Thread {
    @Override
    public void run(){

        try {
            System.out.println("Run ThreadName:"+this.currentThread().getName()+" begin="+System.currentTimeMillis());
            Thread.sleep(2000);//sleep()方法让正在执行的线程休眠2秒，正在执行的线程指：this.currentThread()线程
            System.out.println("Run ThreadName:"+ this.currentThread().getName()+" end="+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

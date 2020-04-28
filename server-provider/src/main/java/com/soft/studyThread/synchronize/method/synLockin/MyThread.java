package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 13:46
 * @Version 1.0
 **/
public class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Thread name:"+Thread.currentThread().getName());
        Service service = new Service();
        service.service1();
    }
}

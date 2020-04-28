package com.soft.studyThread.synchronize.method.throwexceptionnolock;

/**
 * @author ZWJ
 * @date 2019/8/29 14:49
 * @Version 1.0
 **/
public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service){
        this.service = service;
    }
    @Override
    public void run(){
        service.testMethod();
    }
}

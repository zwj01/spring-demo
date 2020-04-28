package com.soft.studyThread.synchronize.method.throwexceptionnolock;

/**
 * @author ZWJ
 * @date 2019/8/29 14:48
 * @Version 1.0
 **/
public class ThreadA extends Thread {

    private Service service;

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}

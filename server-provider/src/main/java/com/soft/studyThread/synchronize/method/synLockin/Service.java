package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 13:44
 * @Version 1.0
 **/
public class Service {

    synchronized public void service1() {
        System.out.println("service1");
        System.out.println("当前线程："+Thread.currentThread().getName());
        service2();
    }

    synchronized public void service2() {
        System.out.println("service2");
        System.out.println("当前线程："+Thread.currentThread().getName());
        service3();
    }

    synchronized public void service3() {
        System.out.println("service3");
        System.out.println("当前线程："+Thread.currentThread().getName());
    }
}

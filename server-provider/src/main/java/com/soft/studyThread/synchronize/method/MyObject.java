package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 13:10
 * @Version 1.0
 **/
public class MyObject {
   synchronized public void methodA(){

        try {
            System.out.println("begin methodA() threadName=" + Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end time:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    synchronized public void methodB(){

        try {
            System.out.println("begin methodB threadName="+Thread.currentThread().getName());
            Thread.sleep(5000);
            System.out.println("end time:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

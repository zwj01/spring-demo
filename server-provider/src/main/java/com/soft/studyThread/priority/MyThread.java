package com.soft.studyThread.priority;

/**
 * @author ZWJ
 * @date 2019/8/29 10:20
 * @Version 1.0
 **/
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread Run priority=" + this.getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}

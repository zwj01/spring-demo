package com.soft.studyThread.priority;

/**
 * @author ZWJ
 * @date 2019/8/29 10:25
 * @Version 1.0
 **/
public class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 Run priority=" + this.getPriority());
    }
}

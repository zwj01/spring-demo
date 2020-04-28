package com.soft.studyThread;

/**
 * @author ZWJ
 * @date 2019/8/27 15:42
 * @Version 1.0
 **/
public class MyThread  extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread1");
    }
}

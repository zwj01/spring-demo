package com.soft.studyThread;

/**
 * @author ZWJ
 * @date 2019/8/27 16:28
 * @Version 1.0
 **/
public class MyRunable implements Runnable {
    @Override
    public void run() {
        System.out.println("运行中的线程："+ Thread.currentThread().getName());
    }
}

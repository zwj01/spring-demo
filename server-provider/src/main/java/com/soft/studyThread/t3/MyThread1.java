package com.soft.studyThread.t3;

/**
 * @author ZWJ
 * @date 2019/8/27 16:45
 * @Version 1.0
 **/
public class MyThread1 extends Thread {
    private int count = 5;


    @Override
    synchronized public void run() {
        super.run();
            count--;
            System.out.println("由 " + Thread.currentThread().getName() + "计算，count" + count);
    }
}

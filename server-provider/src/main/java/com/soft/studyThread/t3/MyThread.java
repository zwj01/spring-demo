package com.soft.studyThread.t3;

/**
 * @author ZWJ
 * @date 2019/8/27 16:36
 * @Version 1.0
 **/
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        super();
        this.setName(name);//设置线程名称
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由 " + Thread.currentThread().getName() + "计算，count" + count);
        }
    }
}

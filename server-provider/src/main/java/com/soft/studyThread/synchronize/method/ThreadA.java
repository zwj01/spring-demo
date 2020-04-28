package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 13:12
 * @Version 1.0
 **/
public class ThreadA extends Thread {

    private MyObject myObject;

    public ThreadA(MyObject myObject) {
        super();
        this.myObject = myObject;
    }

    @Override
    public void run() {
        super.run();
        myObject.methodA();
    }
}

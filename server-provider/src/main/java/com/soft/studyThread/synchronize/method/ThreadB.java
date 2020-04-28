package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 13:14
 * @Version 1.0
 **/
public class ThreadB extends Thread {

    private MyObject myObject;

    public ThreadB(MyObject myObject){
        super();
        this.myObject = myObject;
    }

    @Override
    public void run(){
        super.run();
        myObject.methodB();
    }
}

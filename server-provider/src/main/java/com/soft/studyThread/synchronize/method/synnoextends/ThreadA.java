package com.soft.studyThread.synchronize.method.synnoextends;

/**
 * @author ZWJ
 * @date 2019/8/29 15:20
 * @Version 1.0
 **/
public class ThreadA extends Thread {
    private Sub sub;
    public ThreadA(Sub sub){
        super();
        this.sub = sub;
    }

    @Override
    public void run(){
        sub.serviceMethod();
    }
}

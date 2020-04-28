package com.soft.studyThread.synchronize.method.synnoextends;

/**
 * @author ZWJ
 * @date 2019/8/29 15:21
 * @Version 1.0
 **/
public class ThreadB extends Thread {
    private Sub sub;
    public ThreadB(Sub sub){
        super();
        this.sub = sub;
    }

    @Override
    public void run(){
        sub.serviceMethod();
    }
}

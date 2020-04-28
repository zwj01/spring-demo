package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 14:15
 * @Version 1.0
 **/
public class MyThreadA extends Thread {
    @Override
    public void run(){
        Sun sun = new Sun();
        sun.operateISubMethod();
    }
}

package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 14:21
 * @Version 1.0
 **/
public class MyThread extends Thread {
    @Override
    public void run(){
        super.run();
        for (int i = 0; i < 100000;i ++){
            System.out.println("i="+ (i+1));
        }
    }
}

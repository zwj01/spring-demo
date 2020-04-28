package com.soft.studyThread.priority.t2;

/**
 * @author ZWJ
 * @date 2019/8/29 10:47
 * @Version 1.0
 **/
public class MyThreadB extends Thread {

    private int count = 0;

    public int getCount(){
        return count;
    }

    @Override
    public void run(){
        while (true){
            count++;
        }
    }
}

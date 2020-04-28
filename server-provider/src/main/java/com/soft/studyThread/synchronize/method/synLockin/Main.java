package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 14:10
 * @Version 1.0
 **/
public class Main {
    public int i = 10;
    synchronized public void oprateTMainMethod(){

        try {
            i--;
            System.out.println("main print i="+i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

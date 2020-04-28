package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 17:48
 * @Version 1.0
 **/
public class Run5 {
    public static void main(String[] args){

        try {
            BLStopThread blStopThread = new BLStopThread();
            blStopThread.start();
            Thread.sleep(8000);
            blStopThread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

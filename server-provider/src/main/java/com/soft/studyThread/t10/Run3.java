package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 15:55
 * @Version 1.0
 **/
public class Run3 {
    public static void main(String[] args){

        try {
            SleepStopThread sleepStopThread = new SleepStopThread();
            sleepStopThread.start();
            Thread.sleep(200);
            sleepStopThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main match");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

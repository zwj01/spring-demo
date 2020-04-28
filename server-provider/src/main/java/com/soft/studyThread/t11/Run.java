package com.soft.studyThread.t11;

/**
 * @author ZWJ
 * @date 2019/8/28 15:16
 * @Version 1.0
 **/
public class Run {

    public static void main(String[] args){

        try {
            MyThread myThread = new MyThread();
            myThread.start();
            //myThread.interrupt();
            Thread.sleep(1000);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main match");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}

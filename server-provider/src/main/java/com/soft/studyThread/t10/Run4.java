package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 16:04
 * @Version 1.0
 **/
public class Run4 {
    /**
     * 先interrupt在sleep来停止
     * @param args
     */
    public static void main(String[] args){
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
        myThread2.interrupt();
        System.out.println("End!");
    }

}

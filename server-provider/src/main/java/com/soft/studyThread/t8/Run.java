package com.soft.studyThread.t8;

/**
 * @author ZWJ
 * @date 2019/8/28 13:56
 * @Version 1.0
 **/
public class Run {

    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        Thread thread1 = new Thread(myThread);
        thread.setName("A");
        thread1.setName("B");
        System.out.println("begin:"+System.currentTimeMillis());
        thread.start();
        thread1.start();
        System.out.println("end:"+System.currentTimeMillis());
    }
}

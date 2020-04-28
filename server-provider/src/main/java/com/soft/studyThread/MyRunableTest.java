package com.soft.studyThread;

/**
 * @author ZWJ
 * @date 2019/8/27 16:29
 * @Version 1.0
 **/
public class MyRunableTest {

    public static void main(String[] args){
        MyRunable myRunable = new MyRunable();
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myRunable);
        Thread thread = new Thread(myThread);
        thread1.start();
        thread.start();
        System.out.println("执行结束啦！"+ Thread.currentThread().getName());
    }
}

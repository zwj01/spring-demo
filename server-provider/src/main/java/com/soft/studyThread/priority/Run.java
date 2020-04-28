package com.soft.studyThread.priority;

/**
 * @author ZWJ
 * @date 2019/8/29 10:27
 * @Version 1.0
 **/
public class Run {
    /**
     * 多线程的优先级具有继承性
     * 如A启动线程B，则B与A线程的优先级是一样的。
     * @param args
     */
    public static void main(String[] args){
        System.out.println("main thread begin priority="+Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority="+Thread.currentThread().getPriority());
        MyThread myThread = new MyThread();
        myThread.start();
    }
}

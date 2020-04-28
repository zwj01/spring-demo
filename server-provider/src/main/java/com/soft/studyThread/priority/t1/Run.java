package com.soft.studyThread.priority.t1;

/**
 * @author ZWJ
 * @date 2019/8/29 10:38
 * @Version 1.0
 **/
public class Run {
    /**
     * 线程优先级规则
     * 优先级越高，大部分线程越先执行完，但并不一定就会先执行完。（随机性）
     * @param args
     */
    public static void main(String[] args){
        for (int i = 0;i < 5;i++){
            MyThread myThread = new MyThread();
            myThread.setPriority(5);
            myThread.start();
            MyThread1 myThread1 = new MyThread1();
            myThread1.setPriority(6);
            myThread1.start();

        }
    }
}

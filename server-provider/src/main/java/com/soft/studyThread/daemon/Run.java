package com.soft.studyThread.daemon;

/**
 * @author ZWJ
 * @date 2019/8/29 11:01
 * @Version 1.0
 **/
public class Run {
    public static void main(String[] args){

        try {MyThread myThread = new MyThread();
            /**
             * MyThread设置成守护线程，只有当最后一个非守护线程结束时，守护线程才随着jvm一同结束任务
             */
            myThread.setDaemon(true);
            myThread.start();
            Thread.sleep(5000);
            System.out.println("我离开thread线程对呀，也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

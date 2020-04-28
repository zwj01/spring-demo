package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 14:30
 * @Version 1.0
 **/
public class Run {

    public static void main(String[] args) {

        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(20000);
            myThread.interrupt();
            System.out.println("测试线程是否停止1："+ myThread.isInterrupted());
            /**
             * isInterrupted 测试线程是否处于中断状态  并不清除状态
             */
            System.out.println("测试线程是否停止2："+ myThread.isInterrupted());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

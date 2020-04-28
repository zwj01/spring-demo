package com.soft.studyThread.synchronize.method.malpractice;

/**
 * @author ZWJ
 * @date 2019/8/29 17:19
 * @Version 1.0
 **/
public class Run {
    public static void main(String[] args) {
        Task task = new Task();
        MyThread myThread = new MyThread(task);
        myThread.start();
        MyThread2 myThread2 = new MyThread2(task);
        myThread2.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long begintime = CommonUtils.beginTime1;
        if (CommonUtils.beginTime2 < CommonUtils.beginTime1){
            begintime = CommonUtils.beginTime2;
        }
        long endtime = CommonUtils.endTime1;
        if (CommonUtils.endTime2 > CommonUtils.endTime1){
            endtime = CommonUtils.endTime2;
        }
        System.out.println("耗时："+(endtime-begintime)/1000);
    }
}

package com.soft.studyThread.synchronize.method.malpractice;

/**
 * @author ZWJ
 * @date 2019/8/29 17:21
 * @Version 1.0
 **/
public class MyThread2 extends Thread {
    private Task task;
    public MyThread2(Task task){
        super();
        this.task = task;
    }

    @Override
    public void run(){
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime2 = System.currentTimeMillis();
    }
}

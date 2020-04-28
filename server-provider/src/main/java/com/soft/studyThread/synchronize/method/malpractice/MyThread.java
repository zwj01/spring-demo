package com.soft.studyThread.synchronize.method.malpractice;

/**
 * @author ZWJ
 * @date 2019/8/29 17:02
 * @Version 1.0
 **/
public class MyThread extends Thread {
    private Task task;

    public MyThread(Task task) {
        super();
        this.task = task;
    }

    @Override
    public void run() {
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

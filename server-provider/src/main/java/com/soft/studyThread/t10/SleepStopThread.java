package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 15:52
 * @Version 1.0
 **/
public class SleepStopThread extends Thread {
    @Override
    public void run(){
        super.run();

        try {
            System.out.println("Run begin!");
            Thread.sleep(20000);
            System.out.println("Run end!");
        } catch (InterruptedException e) {
            System.out.println("线程："+Thread.currentThread().getName()+"在睡眠中停止！"+this.isInterrupted());
            e.printStackTrace();
        }
    }

}

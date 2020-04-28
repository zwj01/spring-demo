package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 17:52
 * @Version 1.0
 **/
public class BLStopThread2 extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e){
            System.out.println("进入了Catch方法！");
            e.printStackTrace();
        }

    }
}

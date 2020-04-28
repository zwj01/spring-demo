package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 16:12
 * @Version 1.0
 **/
public class BLStopThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

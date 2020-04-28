package com.soft.studyThread.daemon;

/**
 * @author ZWJ
 * @date 2019/8/29 10:58
 * @Version 1.0
 **/
public class MyThread extends Thread {

    private int count = 0;

    @Override
    public void run() {

        try {
            while (true) {
                count++;
                System.out.println("count=" + count);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

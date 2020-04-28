package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 16:01
 * @Version 1.0
 **/
public class MyThread2 extends Thread {
    @Override
    public void run(){
        super.run();

        try {
            for (int i=0;i < 10000000;i++){
                System.out.println("i="+(i+1));
            }
            System.out.println("Run begin!");
            Thread.sleep(20000);
            System.out.println("Run end");
        } catch (InterruptedException e) {
            System.out.println("先停止，再遇到了sleep，在进入match！");
            e.printStackTrace();
        }
    }
}

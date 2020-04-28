package com.soft.studyThread;

/**
 * @author ZWJ
 * @date 2019/8/27 15:52
 * @Version 1.0
 **/

public class MyThread1 extends Thread {

    private int i;

    public MyThread1(int i){
        super();
        this.i = i;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);

                Thread.sleep(time);
                System.out.println("Run=" + Thread.currentThread().getName()+",i="+i);//获取线程名称
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

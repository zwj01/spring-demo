package com.soft.studyThread.t11;

/**
 * @author ZWJ
 * @date 2019/8/28 15:13
 * @Version 1.0
 **/
public class MyThread extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 1000000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("线程已经是停止状态了！我要退出啦。。。吼吼吼");
                    throw new InterruptedException();
                }
                System.out.println("i=" + (i + 1));
            }
            System.out.println("我被输出啦，我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进MyThread.java类run方法中的match啦");
            e.printStackTrace();
        }

    }
}

package com.soft.studyThread.priority.t2;

/**
 * @author ZWJ
 * @date 2019/8/29 10:48
 * @Version 1.0
 **/
public class Run {
    /**
     * 优先级高的跑得快，也就计算的多
     * @param args
     */
    public static void main(String[] args){

        try {
            MyThreadA myThreadA = new MyThreadA();
            myThreadA.setPriority(Thread.NORM_PRIORITY -3);
            myThreadA.start();
            MyThreadB myThreadB = new MyThreadB();
            myThreadB.setPriority(Thread.NORM_PRIORITY + 3);
            myThreadB.start();
            Thread.sleep(20000);
            myThreadA.stop();
            myThreadB.stop();
            System.out.println("a="+myThreadA.getCount());
            System.out.println("b="+myThreadB.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

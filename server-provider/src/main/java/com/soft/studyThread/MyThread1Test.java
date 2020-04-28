package com.soft.studyThread;

/**
 * @author ZWJ
 * @date 2019/8/27 16:06
 * @Version 1.0
 **/
public class MyThread1Test {
    public static void main(String[] args){
        try {
            MyThread1 myThread1 = new MyThread1(1);
            myThread1.setName("myThread");
            /**
             * 调用start和run的区别
             * start 线程告诉“线程规划器”已经准备就绪  等待执行run方法  异步处理
             * run由main方法调用run方法，执行完run才会继续执行下去 同步处理
             */
            myThread1.start();
            for (int i = 0;i < 10 ;i++){
                int time = (int) (Math.random()*1000);
                Thread.sleep(time);
                System.out.println("main="+Thread.currentThread().getName());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

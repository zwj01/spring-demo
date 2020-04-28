package com.soft.studyThread.yield;

/**
 * @author ZWJ
 * @date 2019/8/29 9:37
 * @Version 1.0
 **/
public class MyThread extends Thread {

    @Override
    public void run() {
        long begintime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 500000; i++){
            count = count + (i + 1);
            /**
             * yield 该方法让线程放弃当前cpu资源，让给其它任务执行，再次获取CPU时间不定
             */
            Thread.yield();
            System.out.println("count:"+count);
        }
        long endtime = System.currentTimeMillis();
        System.out.println("用时："+ (endtime - begintime) + "毫秒！");
    }
}

package com.soft.studyThread.synchronize.method.synnoextends;

/**
 * @author ZWJ
 * @date 2019/8/29 15:16
 * @Version 1.0
 **/
public class Main {

    synchronized public void serviceMethod(){
        try {
            System.out.println("第一步 线程名称："+Thread.currentThread().getName()+",time:"+System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("第二步 线程名称："+Thread.currentThread().getName()+",time:"+System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

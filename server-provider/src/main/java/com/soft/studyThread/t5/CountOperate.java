package com.soft.studyThread.t5;

/**
 * @author ZWJ
 * @date 2019/8/28 11:38
 * @Version 1.0
 **/
public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate begin");
        System.out.println("Thread.currentThread.getName:-----------------" + Thread.currentThread().getName());
        System.out.println("Thread.currentThread.isAlive:--------------"+Thread.currentThread().isAlive());
        System.out.println("this.getName:+++++++++++++++" + this.getName());
        System.out.println("this.isAlive:+++++++++"+this.isAlive());
        System.out.println("CountOperate end");
    }

    @Override
    public void run() {
        System.out.println("Run==========: begin");
        System.out.println("Run:Thread.currentThread.getName:======" + Thread.currentThread().getName());
        System.out.println("Run:Thread.currentThread.isAlive:--------------"+Thread.currentThread().isAlive());
        System.out.println("Run:this.getName:+++++++++++++++" + this.getName());
        System.out.println("Run:this.isAlive:+++++++++"+this.isAlive());
        System.out.println("Run end");
    }
}

package com.soft.studyThread.t10;

/**
 * @author ZWJ
 * @date 2019/8/28 15:04
 * @Version 1.0
 **/
public class Run2 {
    public static void main(String[] args){
        Thread.currentThread().interrupt();
        System.out.println("测试线程是否停止1："+ Thread.interrupted());
        /**
         * interrupted作用
         * 判断当前线程状态
         * 清楚线程的中断状态
         */
        System.out.println("测试线程是否停止2："+ Thread.interrupted());
        System.out.println("end");
    }
}

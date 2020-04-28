package com.soft.studyThread.t9;

/**
 * @author ZWJ
 * @date 2019/8/28 14:07
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args){
        Thread thread = Thread.currentThread();
        /**
         * getId();获取线程唯一标识
         */
        System.out.println("Thread id:"+ thread.getId()+",Thread name:"+thread.getName());
    }
}

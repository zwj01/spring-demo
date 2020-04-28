package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 11:17
 * @Version 1.0
 **/
public class Run {
    public static void main(String[] args){
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        Thread1 thread1 = new Thread1(hasSelfPrivateNum);
        thread1.start();
        Thread2 thread2 = new Thread2(hasSelfPrivateNum);
        thread2.start();
    }
}

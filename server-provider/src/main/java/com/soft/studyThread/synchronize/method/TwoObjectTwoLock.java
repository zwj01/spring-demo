package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 11:50
 * @Version 1.0
 **/
public class TwoObjectTwoLock {
    public static void main(String[] args){
        /**
         * 执行过程中产生了两个对象  两个锁
         */
        HasSelfPrivateNum hasSelfPrivateNum = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();
        Thread1 thread1 = new Thread1(hasSelfPrivateNum);
        thread1.start();
        Thread2 thread2 = new Thread2(hasSelfPrivateNum2);
        thread2.start();
    }
}

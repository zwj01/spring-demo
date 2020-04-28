package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 14:16
 * @Version 1.0
 **/
public class MainRun {
    /**
     * 存在父子继承关系时，子类完全可以通过“可重入锁”调用父类的同步方法
     * @param args
     */
    public static void main(String[] args){
        MyThreadA myThreadA = new MyThreadA();
        myThreadA.start();
    }
}

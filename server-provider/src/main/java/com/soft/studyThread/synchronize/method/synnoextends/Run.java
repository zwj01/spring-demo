package com.soft.studyThread.synchronize.method.synnoextends;

/**
 * @author ZWJ
 * @date 2019/8/29 15:22
 * @Version 1.0
 **/
public class Run {

    /**
     * 同步不能继承
     * @param args
     */
    public static void main(String[] args){
        Sub sub = new Sub();
        ThreadA threadA = new ThreadA(sub);
        threadA.setName("A");
        threadA.start();
        ThreadB threadB = new ThreadB(sub);
        threadB.setName("B");
        threadB.start();
    }
}

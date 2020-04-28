package com.soft.studyThread.synchronize.method.dirtyread;

/**
 * @author ZWJ
 * @date 2019/8/29 13:32
 * @Version 1.0
 **/
public class Run {

    public static void main(String[] args){

        try {
            PublicVar publicVar = new PublicVar();
            ThreadA threadA = new ThreadA(publicVar);
            threadA.start();
            Thread.sleep(200);
            publicVar.getValue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

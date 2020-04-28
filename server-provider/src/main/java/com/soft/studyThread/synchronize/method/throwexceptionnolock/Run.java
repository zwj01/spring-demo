package com.soft.studyThread.synchronize.method.throwexceptionnolock;

/**
 * @author ZWJ
 * @date 2019/8/29 14:51
 * @Version 1.0
 **/
public class Run {

    public static void main(String[] args){

        try {
            Service service = new Service();
            ThreadA threadA = new ThreadA(service);
            threadA.setName("a");
            threadA.start();
            Thread.sleep(5000);
            ThreadB threadB = new ThreadB(service);
            threadB.setName("b");
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

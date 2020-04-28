package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 13:48
 * @Version 1.0
 **/
public class Run {
    /**
     * 可重入锁概念;
     * 自己可以获取自己内部的锁。
     * 比如有一条线程获取了某个对象的锁，此时锁还没释放，当再次想要获取还是可以获取的。
     * @param args
     */
    public static void main(String[] args){

        try {
            MyThread myThread = new MyThread();
            MyThrea myThrea = new MyThrea();
            myThrea.setName("a");
            myThread.setName("b");
            Thread.sleep(2000);
            myThread.start();
            myThrea.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package com.soft.studyThread.t3;

/**
 * @author ZWJ
 * @date 2019/8/27 16:41
 * @Version 1.0
 **/
public class MyThreadTest {
    public static void main(String[] args){
        /**
         * MyThread 变量不共享
         */
        /*MyThread a = new MyThread("A");
        MyThread b = new MyThread("B");
        MyThread c = new MyThread("C");
        a.start();
        b.start();
        c.start();*/

        /**
         * MyThread1变量共享 执行多次发现 结果可能会出现重复现象  也就是线程不安全
         * 在run方法加锁后，不再重复
         * 非线程安全：多个线程对同一个对象中的同一实例变量进行操作是会出现
         * 值被更改，值不同步的现象
         */
        MyThread1 myThread1 = new MyThread1();
        Thread a1 = new Thread(myThread1,"A");
        Thread b1 = new Thread(myThread1,"B");
        Thread c1 = new Thread(myThread1,"C");
        Thread d1 = new Thread(myThread1,"D");
        Thread e1 = new Thread(myThread1,"E");
        a1.start();
        b1.start();
        c1.start();
        d1.start();
        e1.start();
    }
}

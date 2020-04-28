package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 13:14
 * @Version 1.0
 **/
public class Run2 {

    public static void main(String[] args){
        /**
         * 脏读一定会出现操作实例变量的情况下，这就是多线程“争抢”实例变量的结果
         * 结论
         * 1、A线程先持有MyObject对象的lock锁，B线程可以异步调用MyObject中的非synchronized方法
         * 2、A线程先持有MyObject对象的lock锁，B线程调用MyObject中的synchronizes需等待A线程释放锁，也就是同步调用
         */
        MyObject myObject = new MyObject();
        ThreadA threadA = new ThreadA(myObject);
        threadA.setName("A");
        ThreadB threadB = new ThreadB(myObject);
        threadB.setName("B");
        threadA.start();
        threadB.start();
    }
}

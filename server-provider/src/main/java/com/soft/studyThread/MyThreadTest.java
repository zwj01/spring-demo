package com.soft.studyThread;

/**
 * @author ZWJ
 * @date 2019/8/27 15:44
 * @Version 1.0
 **/
public class MyThreadTest {
    /**
     * 线程调用的随机性
     * 执行多次发现  输出1  和输出2  输出顺序并不是固定不变的 也就是代码运行结果与执行顺序或调用顺序无关
     * @param args
     */
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1(1);
        MyThread1 myThread2 = new MyThread1(2);
        MyThread1 myThread3 = new MyThread1(3);
        MyThread1 myThread4 = new MyThread1(4);
        MyThread1 myThread5 = new MyThread1(5);
        MyThread1 myThread6 = new MyThread1(6);
        MyThread1 myThread7 = new MyThread1(7);
        MyThread1 myThread8 = new MyThread1(8);
        MyThread1 myThread9 = new MyThread1(9);
        MyThread1 myThread10 = new MyThread1(10);
        myThread1.start();//输出 MyThread 1
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread5.start();
        myThread6.start();
        myThread7.start();
        myThread8.start();
        myThread9.start();
        myThread10.start();
        System.out.println("执行多线程了哦！"); //输出  2
    }
}

package com.soft.studyThread.synchronize.method.throwexceptionnolock;

/**
 * @author ZWJ
 * @date 2019/8/29 14:35
 * @Version 1.0
 **/
public class Service {
    synchronized public void testMethod(){
        if (Thread.currentThread().getName().equals("a")){
            System.out.println("当前线程名称："+Thread.currentThread().getName()+",开始时间："+System.currentTimeMillis());
            int i = 1;
            while (i == 1){
                if ((""+Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("当前线程名称：" +Thread.currentThread().getName()+",run  ExceptionTime:"+System.currentTimeMillis());
                    Integer.parseInt("a");//该处抛出异常，同时释放锁，B线程正常访问。
                }
            }

        } else {
            System.out.println("Thread B run time"+ System.currentTimeMillis());
        }
    }
}

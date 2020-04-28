package com.soft.studyThread.t5;

/**
 * @author ZWJ
 * @date 2019/8/28 11:42
 * @Version 1.0
 **/
public class CountOperateTest {
    public static void  main(String[] args){
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        //thread.getState();
System.out.println("main begin thread is Alive:"+thread.isAlive());

        thread.setName("A");
        thread.start();
        System.out.println("main end thread isAlive:"+ thread.isAlive());
    }
}

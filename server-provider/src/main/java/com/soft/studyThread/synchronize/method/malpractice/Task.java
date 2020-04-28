package com.soft.studyThread.synchronize.method.malpractice;

/**
 * @author ZWJ
 * @date 2019/8/29 16:50
 * @Version 1.0
 **/
public class Task {
    private String getData1;
    private String getData2;
    synchronized  public void doLongTimeTask(){
        try {
            System.out.println("begin task!");
            Thread.sleep(3000);
            getData1 = "长时间处理任务后从远程返回的值1：ThreadName= "+Thread.currentThread().getName();
            getData2 = "长时间处理任务后从远程返回的值2：ThreadName="+Thread.currentThread().getName();
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end Task!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

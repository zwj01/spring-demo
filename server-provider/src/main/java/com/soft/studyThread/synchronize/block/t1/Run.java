package com.soft.studyThread.synchronize.block.t1;

import com.soft.studyThread.synchronize.method.malpractice.CommonUtils;

/**
 * @author ZWJ
 * @date 2019/8/29 17:47
 * @Version 1.0
 **/
public class Run {
    public static void main(String[] args){
        ObjectService service = new ObjectService();
        ThreadA threadA = new ThreadA(service);
        threadA.setName("a");
        threadA.start();
        ThreadB threadB = new ThreadB(service);
        threadB.setName("b");
        threadB.start();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long begin =  CommonUtils.beginTime2;
       if (CommonUtils.beginTime2 > CommonUtils.beginTime1){
           begin = CommonUtils.beginTime1;
       }
       long end = CommonUtils.endTime2;
       if (CommonUtils.endTime1 > CommonUtils.endTime2){
           end = CommonUtils.endTime1;
       }
       System.out.println("耗时："+(end-begin)/1000);
    }
}

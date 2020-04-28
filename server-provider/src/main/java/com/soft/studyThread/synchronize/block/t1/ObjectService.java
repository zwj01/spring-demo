package com.soft.studyThread.synchronize.block.t1;

/**
 * @author ZWJ
 * @date 2019/8/29 17:35
 * @Version 1.0
 **/
public class ObjectService  {

    public void serviceMethod(){
        try {
            synchronized (this){
                System.out.println("begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("end time="+System.currentTimeMillis());
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

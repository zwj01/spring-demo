package com.soft.studyThread.synchronize.block.t1;

import com.soft.studyThread.synchronize.method.malpractice.CommonUtils;

/**
 * @author ZWJ
 * @date 2019/8/29 17:42
 * @Version 1.0
 **/
public class ThreadB extends Thread {
    private ObjectService service;
    public ThreadB(ObjectService service){
        super();
        this.service =service;
    }

    @Override
    public void run(){
        super.run();
        CommonUtils.beginTime1 = System.currentTimeMillis();
        service.serviceMethod();
        CommonUtils.endTime1 = System.currentTimeMillis();
    }
}

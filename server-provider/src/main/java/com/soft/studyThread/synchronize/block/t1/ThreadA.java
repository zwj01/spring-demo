package com.soft.studyThread.synchronize.block.t1;

import com.soft.studyThread.synchronize.method.malpractice.CommonUtils;

/**
 * @author ZWJ
 * @date 2019/8/29 17:41
 * @Version 1.0
 **/
public class ThreadA extends Thread {
    private ObjectService service;
    public ThreadA(ObjectService service){
        super();
        this.service = service;
    }

    @Override
    public void run(){
        super.run();
        CommonUtils.beginTime2 = System.currentTimeMillis();
        service.serviceMethod();
        CommonUtils.endTime2 =System.currentTimeMillis();
    }
}

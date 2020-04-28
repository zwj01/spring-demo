package com.soft.studyThread.synchronize.method.dirtyread;

/**
 * @author ZWJ
 * @date 2019/8/29 13:33
 * @Version 1.0
 **/
public class ThreadA extends Thread {

    private PublicVar publicVar;
    public ThreadA(PublicVar publicVar){
        super();
        this.publicVar = publicVar;
    }
    @Override
    public void run(){
        super.run();
        publicVar.setValue("b","bb");
    }
}

package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 11:13
 * @Version 1.0
 **/
public class Thread1 extends Thread {

    private HasSelfPrivateNum selfPrivateNum;

    public Thread1(HasSelfPrivateNum selfPrivateNum) {
        super();
        this.selfPrivateNum = selfPrivateNum;
    }

    @Override
    public void run() {
        super.run();
        selfPrivateNum.addI("a");
    }
}

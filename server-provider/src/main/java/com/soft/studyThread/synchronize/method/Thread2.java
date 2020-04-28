package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 11:15
 * @Version 1.0
 **/
public class Thread2 extends Thread {
    private HasSelfPrivateNum selfPrivateNum;

    public Thread2(HasSelfPrivateNum selfPrivateNum) {
        super();
        this.selfPrivateNum = selfPrivateNum;
    }

    @Override
    public void run() {
        super.run();
        selfPrivateNum.addI("b");
    }
}

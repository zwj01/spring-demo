package com.soft.studyThread.synchronize.method.dirtyread;

import com.soft.studyThread.synchronize.method.ThreadB;

/**
 * @author ZWJ
 * @date 2019/8/29 13:26
 * @Version 1.0
 **/
public class PublicVar {
    public String username = "a";
    public String password = "aa";
    synchronized public void setValue(String username,String password){

        try {
            this.username = username;
            Thread.sleep(5000);//线程停在这里的时候，已经执行完外面的线程，外面的线程调用getValue，所以读出来的数据错误
            this.password = password;
            System.out.println("setValue thread name;"+Thread.currentThread().getName()+";username="+username + ";password="+password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getValue() {
        System.out.println("getValue thread name:"+Thread.currentThread().getName()+";username="+username+";password="+password);
    }
}

package com.soft.studyThread.synchronize.method;

/**
 * @author ZWJ
 * @date 2019/8/29 11:10
 * @Version 1.0
 **/
public class HasSelfPrivateNum {
    int num = 0;
   synchronized public void addI(String username) {

        try {

            if (username.equals("a")) {
                num = 100;
                System.out.println("a set Over1");
                Thread.sleep(1000);
            } else {
                num = 200;
                System.out.println("b set Over1");
            }
            System.out.println(username + ";num = " +num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

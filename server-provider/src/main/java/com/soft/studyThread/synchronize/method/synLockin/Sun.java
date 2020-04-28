package com.soft.studyThread.synchronize.method.synLockin;

/**
 * @author ZWJ
 * @date 2019/8/29 14:12
 * @Version 1.0
 **/
public class Sun extends Main {
    synchronized public void operateISubMethod(){

        try {
            while (i > 0){
                i --;
                System.out.println("Sub print i="+i);
                Thread.sleep(100);
                this.oprateTMainMethod();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

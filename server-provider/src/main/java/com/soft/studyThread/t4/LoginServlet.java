package com.soft.studyThread.t4;

/**
 * @author ZWJ
 * @Description模仿登录Servlet组件
 * @date 2019/8/27 16:55
 * @Version 1.0
 **/

public class LoginServlet {
    private static String usernameRef;
    private static String passwordRef;

    public static void doPost(String username, String password) {
        try {
            usernameRef = username;
            if (username.equals("a")) {
                Thread.sleep(5000);
            }
            passwordRef = password;
              System.out.println("username="+username+",password="+password);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

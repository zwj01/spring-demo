package com.soft.controller;


import com.sofg.api.HelloTestApi;
import com.sofg.content.RestApi;
import com.sofg.pojo.ResponseBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZWJ
 * @date 2019/8/16 15:23
 * @Version 1.0
 **/
@RestController
public class HelloTest implements HelloTestApi {

    @Value("${server.port}")
    String port;

    //@RequestMapping(value = "/index",method = RequestMethod.GET)
    @Override
    public ResponseBean getHello(@RequestParam String name){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String s = "Hello，"+name + port;
        System.out.println(s);
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,s);
    }
}

package com.soft.controller;


import com.sofg.api.HelloTestApi;
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

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    @Override
    public String getHello(@RequestParam String name){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello，"+name + port;
    }
}

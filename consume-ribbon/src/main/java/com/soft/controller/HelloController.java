package com.soft.controller;

import com.soft.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZWJ
 * @date 2019/8/16 15:20
 * @Version 1.0
 **/
@RestController
@RequestMapping("/test")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/gethello")
    public String getHello(@RequestParam String name) {
        return helloService.getService(name);
    }
}

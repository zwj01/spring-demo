package com.soft.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZWJ
 * @date 2019/8/16 15:17
 * @Version 1.0
 **/
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getError")
    public String getService(String name){
        //ribbon中它会根据服务名来选择具体的服务实例
        return restTemplate.getForObject("http://server-provider/index?name=" + name, String.class);
    }

    public String getError(String name){
        return "sorry," + name + ",i cannot get it!";
    }
}

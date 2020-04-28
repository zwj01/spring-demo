package com.sofg.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZWJ
 * @date 2019/8/20 10:11
 * @Version 1.0
 **/
public interface HelloTestApi {
    //消费者 提供者都实现这个接口
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    String getHello(@RequestParam("name") String name);
}

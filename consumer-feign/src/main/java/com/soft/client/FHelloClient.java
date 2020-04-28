package com.soft.client;

import com.sofg.api.HelloTestApi;
import com.soft.client.hystrix.HelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ZWJ
 * @version v1.0
 * @Description
 * @date 2019/8/16 16:24
 **/
@FeignClient(value = "server-provider",fallback = HelloService.class) //调用哪个生产者
@Component
public interface FHelloClient extends HelloTestApi {

    /*@RequestMapping(value = "/index",method = RequestMethod.GET) //对应的value表名调用生产者提供的哪个接口
    String getHello(@RequestParam(value = "name") String name);*/
}

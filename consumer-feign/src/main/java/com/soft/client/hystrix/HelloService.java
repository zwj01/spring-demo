package com.soft.client.hystrix;

import com.soft.client.FHelloClient;
import org.springframework.stereotype.Component;

/**
 * @author ZWJ
 * @date 2019/8/16 17:02
 * @Version 1.0
 **/
@Component
public class HelloService implements FHelloClient {
    @Override
    public String getHello(String name) {
        return "Sorry,i cannot get it";
    }
}

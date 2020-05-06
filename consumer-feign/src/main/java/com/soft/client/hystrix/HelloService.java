package com.soft.client.hystrix;

import com.sofg.content.RestApi;
import com.sofg.pojo.ResponseBean;
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
    public ResponseBean getHello(String name) {
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,"Sorry,i cannot get it");
    }
}

package com.sofg.link;

import com.alibaba.fastjson.JSONObject;
import com.sofg.entity.LinkTrace;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;
import java.util.Map;

public class FeignRequestInterceptor implements RequestInterceptor {

    @Autowired
    ShareHandle shareHandle;

    @Value("${spring.application.name}")
    private String name;

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("调用前拦截");
        try {
            LinkTrace linkTrace = new LinkTrace();
            String jsonString= (String)shareHandle.map.get("linkTrace");
            JSONObject jsonObject = JSONObject.parseObject(jsonString);

            String url = template.url();
            //调用服务的请求参数
            Map<String, Collection<String>> queries = template.queries();
            String method = template.method();
            Map<String, Collection<String>> headers = template.headers();

            if (jsonObject != null){
                //跨度id
                Integer pSpanId = jsonObject.getInteger("pSpanId");
                if (pSpanId != 0){
                    linkTrace.setpSpanId(jsonObject.getInteger("pSpanId"));
                }
                linkTrace.setSpandId(jsonObject.getInteger("spandId"));
                //token
                linkTrace.setToken(jsonObject.getString("token"));
                //设置ApiChain
                linkTrace.setApiChain(jsonObject.getString("apiChain"));
                //请求id
                linkTrace.setTraceId(jsonObject.getInteger("traceId"));
            }

            //请求参数
            linkTrace.setParams(queries.toString());

            //服务名称
            linkTrace.setServiceName(name);
            //接收时间
            linkTrace.setReceiveTime(System.currentTimeMillis());
            //发送时间
            linkTrace.setSendTime(System.currentTimeMillis());
            //请求uri
            linkTrace.setUri(url);
            String linkTraceS = JSONObject.toJSONString(linkTrace);
            template.header("conLinkTrace",linkTraceS);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}

package com.sofg.link;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sofg.entity.LinkTrace;
import com.sofg.utils.KafkaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class RequestLinkInterceptor implements HandlerInterceptor {

    @Autowired
    ShareHandle shareHandle;

    @Value("${spring.application.name}")
    String name;

    LinkTrace linkTrace = new LinkTrace();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String zuulLinkTrace = request.getHeader("linktrace");
        Integer hpid = 0;
        if (!StringUtils.isEmpty(zuulLinkTrace)){
            JSONObject object = JSONObject.parseObject(zuulLinkTrace);
            linkTrace.setTraceId(object.getInteger("traceId"));
            linkTrace.setToken(object.getString("token"));
            linkTrace.setParams(object.getString("params"));
            if (StringUtils.isEmpty(object.getString("apiChain"))){
                linkTrace.setApiChain(name);
            } else {
                linkTrace.setApiChain(object.getString("apiChain") + "->" + name);
            }
            if (object.getInteger("spandId") != null){
                linkTrace.setpSpanId(object.getInteger("spandId"));
            }
        } else {

        }
        linkTrace.setServiceName(name);
        String pid = name + request.getRequestURI() + System.currentTimeMillis();
        hpid = pid.hashCode();
        hpid = hpid > 0 ? hpid : -hpid;
        linkTrace.setUri(request.getRequestURI());
        linkTrace.setSpandId(hpid);
        linkTrace.setReceiveTime(System.currentTimeMillis());
        System.out.println("前置处理拦截");
        shareHandle.map.put("linktrace",JSONObject.toJSONString(linkTrace));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("后置处理拦截");
        try {
            Object o = shareHandle.map.get("responseBody");
           JSONObject object =  (JSONObject) JSON.toJSON(o);
           Integer status = object.getInteger("code");
           if (!StringUtils.isEmpty(status)){
               linkTrace.setStatus(status);
           }
            //设置响应体数据
            linkTrace.setResponseBody(JSONObject.toJSONString(o));
            System.out.println("返回数据：" + o.toString());
            linkTrace.setSendTime(System.currentTimeMillis());
            System.out.println("链路信息：" + JSONObject.toJSONString(linkTrace));
            //kafkaTemplate.send("service1.linktrace",JSONObject.toJSONString(linkTrace));
            KafkaUtil.sendMsg("service.linktrace",JSONObject.toJSONString(linkTrace));
        } catch (Exception e){
            e.printStackTrace();
        }


    }
}

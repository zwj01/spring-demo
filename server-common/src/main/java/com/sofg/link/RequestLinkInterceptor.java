package com.sofg.link;

import com.alibaba.fastjson.JSONObject;
import com.sofg.entity.LinkTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
        String zuulLinkTrace = request.getHeader("linkTrace");
        Integer hpid = 0;
        if (!StringUtils.isEmpty(zuulLinkTrace)){

        } else {
            String pid = name + request.getRequestURI() + System.currentTimeMillis();
            hpid = pid.hashCode();
            hpid = hpid > 0 ? hpid : -hpid;
            linkTrace.setpSpanId(hpid);
        }
        linkTrace.setReceiveTime(System.currentTimeMillis());
        System.out.println("前置处理拦截");
        shareHandle.map.put("conLinkTrace",JSONObject.toJSONString(linkTrace));
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
            //设置响应体数据
            linkTrace.setResponseBody(JSONObject.toJSONString(o));
            System.out.println("返回数据：" + o.toString());
            linkTrace.setSendTime(System.currentTimeMillis());
        } catch (Exception e){

        }


    }
}

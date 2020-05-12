package com.soft.filter;


import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


import com.soft.entity.LinkTrace;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ROUTE_TYPE;

@Component
public class LinkTraceFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        try {
            LinkTrace linkTrace = new LinkTrace();
            //Date receiveTime = Calendar.getInstance().getTime();

            RequestContext context = RequestContext.getCurrentContext();
            //JSONObject jsonObject = new JSONObject();
            Map<String, String> zuulRequestHeaders = context.getZuulRequestHeaders();
            String host = zuulRequestHeaders.get("x-forwarded-host");
            String proto = zuulRequestHeaders.get("x-forwarded-proto");
            String prefix = zuulRequestHeaders.get("x-forwarded-prefix");
            String uri = context.get("requestURI").toString();
            String path = proto + ":" + host + prefix + uri;
            String serviceId = context.get("serviceId").toString();
            HttpServletRequest request = context.getRequest();
            String requestId =  path + Calendar.getInstance().getTimeInMillis();
            String method = request.getMethod();

            InputStream in =   request.getInputStream();
            String reqBody = StreamUtils.copyToString(in,Charset.forName("UTF-8"));
            if ("POST".equals(method.toUpperCase())){
                if (reqBody != null){
                    String contType = request.getHeader("content-type");
                    if (contType.contains("multipart/form-data") || contType.contains("application/json")){
                        JSONObject object = JSONObject.parseObject(reqBody);
                        System.out.println(object.toJSONString());
                        linkTrace.setRequestBody(object.toJSONString());
                    }
                }
            } else if ("GET".equals(method.toUpperCase())){
                Map<String, List<String>> requestQueryParams = context.getRequestQueryParams();
                linkTrace.setParams(requestQueryParams.toString());
            }


            Integer rid = requestId.hashCode();
            rid = rid > 0 ? rid : -rid;
            linkTrace.setTraceId(rid);

            linkTrace.setUri(uri);
            linkTrace.setReceiveTime(System.currentTimeMillis());
            linkTrace.setToken("token");
            linkTrace.setServiceName(serviceId);
            context.addZuulRequestHeader("linktrace",JSONObject.toJSONString(linkTrace));
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

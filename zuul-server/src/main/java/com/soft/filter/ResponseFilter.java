package com.soft.filter;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.soft.entity.LinkTrace;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Calendar;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;

@Component
public class ResponseFilter extends ZuulFilter {





    @Override
    public String filterType() {
        return POST_TYPE;
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
            System.out.println("回来啦");
            RequestContext context = RequestContext.getCurrentContext();
            String linktrace = context.getZuulRequestHeaders().get("linktrace");
            LinkTrace linkTrace = JSONObject.parseObject(linktrace,LinkTrace.class);
            linkTrace.setSendTime(Calendar.getInstance().getTime());
            InputStream responseDataStream = context.getResponseDataStream();
            String responseBody = StreamUtils.copyToString(responseDataStream,Charset.forName("UTF-8"));
            System.out.println("返回的数据：" + responseBody);
            linkTrace.setResponseBody(responseBody);
            context.setResponseDataStream(new ByteArrayInputStream(responseBody.getBytes()));
            System.out.println("返回结果：" + responseDataStream);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

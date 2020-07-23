package com.soft.fund.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

@Component
public class HttpUtils {

    private PoolingHttpClientConnectionManager cm;

    public HttpUtils() {
        this.cm = new PoolingHttpClientConnectionManager();
    }

    /**
     * 根据请求和参数获取数据
     * @return
     */
    public String doGetData(){
        //获取httpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(this.cm).build();
        //创建httpGet对象
        try {
            URIBuilder uriBuilder = new URIBuilder("");
            HttpGet httpGet = new HttpGet(uriBuilder.build());
            //使用httpClient发起请求，获取响应
            CloseableHttpResponse response = httpClient.execute(httpGet);
            //解析响应，返回结果
            if (response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, "utf8");
                int start =  content.indexOf("[");
                int end = content.indexOf("]");
                content = content.substring(start+2,end-1);
                return content;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

package com.soft.crawler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.util.UriBuilder;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws Exception {

        //1、打开一个浏览器，创建一个HttpClient对象
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();

        //2、输入网址 创建HttpGet对象
        //HttpGet httpGet = new HttpGet("http://www.itcast.cn/");

        //UrIBuilder uriBuilder = new UriBuilder("http://fund.eastmoney.com/data/rankhandler.aspx");
        URIBuilder uriBuilder = new URIBuilder("http://fund.eastmoney.com/data/rankhandler.aspx");
        uriBuilder.setParameter("op","ph").
                setParameter("dt","kf").
                setParameter("ft","all").
                setParameter("rs","").
                setParameter("gs","0").
                setParameter("sc","zzf").
                setParameter("st","desc").
                setParameter("sd","2019-07-23").
                setParameter("ed","2020-07-23").
                setParameter("qdii","").
                setParameter("tabSubtype",",,,,,").
                setParameter("pi","1").
                setParameter("pn","50").
                setParameter("dx","1").
                setParameter("v","0.24809865780847162");


        HttpGet httpGet = new HttpGet(uriBuilder.build());

        httpGet.setHeader("Accept","*/*");
        httpGet.setHeader("Accept-Encoding","gzip, deflate");
        httpGet.setHeader("Accept-Language","zh-CN,zh;q=0.9");
        httpGet.setHeader("Connection","keep-alive");
        httpGet.setHeader("Cookie","qgqp_b_id=cb77fa0b484e579b3303e67c2aa02136; em_hq_fls=js; emshistory=%5B%22300810%22%5D; em-quote-version=topspeed; intellpositionL=1215.35px; HAList=a-sh-600677-*ST%u822A%u901A%2Ca-sz-300810-%u4E2D%u79D1%u6D77%u8BAF%2Ca-sh-601888-%u4E2D%u56FD%u4E2D%u514D; st_si=40208470598219; ASP.NET_SessionId=p23ra3l3tnrem1bakhcfvce2; st_asi=delete; intellpositionT=2655px; EMFUND1=null; EMFUND2=null; EMFUND3=null; EMFUND4=null; EMFUND5=null; EMFUND6=null; EMFUND7=null; EMFUND0=null; EMFUND8=07-21%2010%3A51%3A50@%23%24%u65B0%u534E%u6CAA%u6DF1300%u6307%u6570%u589E%u5F3AA@%23%24005248; EMFUND9=07-22 12:37:54@#$%u5E7F%u53D1%u591A%u5143%u65B0%u5174%u80A1%u7968@%23%24003745; _adsame_fullscreen_18186=1; st_pvi=42319971059668; st_sp=2020-07-08%2014%3A03%3A35; st_inirUrl=https%3A%2F%2Fwww.baidu.com%2Flink; st_sn=50; st_psi=20200722150251798-0-9301854402");
        httpGet.setHeader("Host","fund.eastmoney.com");
        httpGet.setHeader("Referer","http://fund.eastmoney.com/data/fundranking.html");
        httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36");

        CloseableHttpResponse response = null;
        try {
            //3、按回车发送请求，使用HTTP Client发起请求
            response = closeableHttpClient.execute(httpGet);
            //4、解析响应，获取数据
            //判断请求状态是否是200
            if (response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity, "utf8");
               int start =  content.indexOf("[");
               int end = content.indexOf("]");
               content = content.substring(start+2,end-1);
               System.out.println(content);
                //JSONObject object = JSONObject.parseObject(content);
                //object.get("datas");
                //JSONArray datas = object.getJSONArray("datas");
               //System.out.println(datas);
                String[] split = content.split("\",\"");

                for (String s : split){
                    System.out.println(s);
                }
                System.out.println("数据长度：" + split.length);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
                closeableHttpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

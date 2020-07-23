package com.soft.shares.service.impl;

import com.soft.shares.entity.LinkTypeDataEntity;
import com.soft.shares.entity.RuleEntity;
import com.soft.shares.exception.RuleException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 核心查询类
 */
public class ExtractServiceImpl {

    /**
     * @param rule
     * @return
     */
    public static List<LinkTypeDataEntity> extract(RuleEntity rule)
    {

        // 进行对rule的必要校验
        validateRule(rule);

        List<LinkTypeDataEntity> datas = new ArrayList<LinkTypeDataEntity>();
        LinkTypeDataEntity data = null;
        try
        {
            /**
             * 解析rule
             */
            String url = rule.getUrl();
            String[] params = rule.getParams();
            String[] values = rule.getValues();
            String resultTagName = rule.getResultTagName();
            int type = rule.getType();
            int requestType = rule.getRequestMoethod();

            Connection conn = Jsoup.connect(url);
            // 设置查询参数

            if (params != null)
            {
                for (int i = 0; i < params.length; i++)
                {
                    conn.data(params[i], values[i]);
                }
            }

            // 设置请求类型
            Document doc = null;
            switch (requestType)
            {
                case RuleEntity.GET:
                    doc = conn.timeout(100000).get();
                    break;
                case RuleEntity.POST:
                    doc = conn.timeout(100000).post();
                    break;
            }

            //处理返回数据
            Elements results = new Elements();
            switch (type)
            {
                case RuleEntity.CLASS:
                    results = doc.getElementsByClass(resultTagName);
                    break;
                case RuleEntity.ID:
                    Element result = doc.getElementById(resultTagName);
                    results.add(result);
                    break;
                case RuleEntity.SELECTION:
                    results = doc.select(resultTagName);
                    break;
                default:
                    //当resultTagName为空时默认去body标签
                    if (StringUtils.isEmpty(resultTagName))
                    {
                        results = doc.getElementsByTag("body");
                    }
            }

            for (Element result : results)
            {
                Elements links = result.getElementsByTag("a");

                for (Element link : links)
                {
                    //必要的筛选
                    String linkHref = link.attr("href");
                    String linkText = link.text();

                    data = new LinkTypeDataEntity();
                    data.setLinkHref(linkHref);
                    data.setLinkText(linkText);

                    datas.add(data);
                }
            }

        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return datas;
    }

    /**
     * 对传入的参数进行必要的校验
     */
    private static void validateRule(RuleEntity rule)
    {
        String url = rule.getUrl();
        if (StringUtils.isEmpty(url))
        {
            throw new RuleException("url不能为空！");
        }
        if (!url.startsWith("http://"))
        {
            throw new RuleException("url的格式不正确！");
        }

        if (rule.getParams() != null && rule.getValues() != null)
        {
            if (rule.getParams().length != rule.getValues().length)
            {
                throw new RuleException("参数的键值对个数不匹配！");
            }
        }

    }
}

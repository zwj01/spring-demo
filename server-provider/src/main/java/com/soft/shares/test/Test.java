package com.soft.shares.test;

import com.soft.shares.entity.LinkTypeDataEntity;
import com.soft.shares.entity.RuleEntity;
import com.soft.shares.service.impl.ExtractServiceImpl;

import java.util.List;

public class Test {


    public static void getDatasByClass()
    {
        RuleEntity rule = new RuleEntity(
                "http://www1.sxcredit.gov.cn/public/infocomquery.do?method=publicIndexQuery",
                new String[] { "query.enterprisename","query.registationnumber" }, new String[] { "兴网","" },
                "cont_right", RuleEntity.CLASS, RuleEntity.POST);
        List<LinkTypeDataEntity> extracts = ExtractServiceImpl.extract(rule);
        printf(extracts);
    }

    public static void main(String[] args){
            //getDatasByClass();
        //getDatasByCssQuery();
        jxString();
    }


    public static void getDatasByCssQuery()
    {
        RuleEntity rule = new RuleEntity("http://www.11315.com/search",
                new String[] { "name" }, new String[] { "兴网" },
                "div.g-mn div.con-model", RuleEntity.SELECTION, RuleEntity.GET);
        List<LinkTypeDataEntity> extracts = ExtractServiceImpl.extract(rule);
        printf(extracts);
    }

    public static void printf(List<LinkTypeDataEntity> datas)
    {
        for (LinkTypeDataEntity data : datas)
        {
            System.out.println(data.getLinkText());
            System.out.println(data.getLinkHref());
            System.out.println("***********************************");
        }

    }

    private static void jxString(){
        String s = "004128,前海联合泳隆混合A,QHLHYLHHA,2020-07-22,1.4541,1.6321,1.6782,9.6028,23.1245,27.1177,17.1716,27.3627,39.2991,,17.3797,69.6493,2017-08-29,1,26.8073,1.50%,0.15%,1,0.15%,1,";
        String[] ss = s.split(",");
        for (String s2 : ss){
            System.out.println(s2);
        }
    }
}

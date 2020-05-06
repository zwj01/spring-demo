package com.soft.dao.impl;

import com.soft.dao.LinkTraceDao;
import com.soft.entity.LinkTrace;
import com.soft.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class LinkTraceDaoImpl implements LinkTraceDao {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<LinkTrace> findLinkTrace(LinkTrace linkTrace) {
        Query query = new Query(Criteria.where("traceId").is(linkTrace.getTraceId()));
        List<LinkTrace> linkTraces = template.find(query,LinkTrace.class);
        return linkTraces;
    }

    @Override
    public List<LinkTrace> findLinkTraceByParam(Map param) {
        String serviceName = param.get("serviceName").toString();
        Object status = param.get("status");
        if (!StringUtils.isEmpty(serviceName)){

        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        String start = param.get("start").toString();
        String end = param.get("end").toString();
        Query query = new Query();
        try {
           Date sD =  sdf.parse(start);
           Date eD = sdf.parse(end);
            query.addCriteria(Criteria.where("sendTime").gte(simpleDateFormat.parse(DateUtil.dateToIsoDate(sD)))
                    .lte(simpleDateFormat.parse(DateUtil.dateToIsoDate(eD))));
        } catch (Exception e){
            e.printStackTrace();
        }
        if (!StringUtils.isEmpty(serviceName)){
            query.addCriteria(Criteria.where("serviceName").is(serviceName));
        }

        if (!StringUtils.isEmpty(status)){
            query.addCriteria(Criteria.where("status").is(Integer.parseInt(status.toString())));
        }
        List<LinkTrace> list = template.find(query,LinkTrace.class);
        return list;
        /*Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("sendTime").gte(start),
                Criteria.where("sendTime").lte(end));*/
        //Query query = new Query(Criteria.where("sendTime").gte(start).and("sendTime").lte(end));
    }

    @Override
    public List<LinkTrace> findLinkTraceByStatus(Integer status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(status));
        List<LinkTrace> list = template.find(query,LinkTrace.class);
        return list;
    }
}

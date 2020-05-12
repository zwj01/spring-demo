package com.soft.dao.impl;

import com.soft.dao.LinkTraceDao;
import com.soft.entity.LinkTrace;
import com.soft.pojo.LinkTracePojo;
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
    public List<LinkTracePojo> findLinkTrace(LinkTracePojo linkTrace) {
        Query query = null;
        if (linkTrace.getTraceId() != null){
            query = new Query(Criteria.where("traceId").is(linkTrace.getTraceId()));
        }

        if (linkTrace.getSpandId() != null){
            query = new Query(Criteria.where("spandId").is(linkTrace.getSpandId()));
        }
        List<LinkTracePojo> linkTraces = template.find(query,LinkTracePojo.class);
        return linkTraces;
    }

    @Override
    public List<LinkTracePojo> findLinkTraceByParam(Map param) {
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
        List<LinkTracePojo> list = template.find(query,LinkTracePojo.class);
        return list;
        /*Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("sendTime").gte(start),
                Criteria.where("sendTime").lte(end));*/
        //Query query = new Query(Criteria.where("sendTime").gte(start).and("sendTime").lte(end));
    }

    @Override
    public List<LinkTracePojo> findLinkTraceByStatus(Integer status) {
        Query query = new Query();
        query.addCriteria(Criteria.where("status").is(status));
        List<LinkTracePojo> list = template.find(query,LinkTracePojo.class);
        return list;
    }
}

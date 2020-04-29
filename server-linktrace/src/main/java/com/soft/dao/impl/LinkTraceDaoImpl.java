package com.soft.dao.impl;

import com.soft.dao.LinkTraceDao;
import com.soft.entity.LinkTrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;


import java.util.List;

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
}

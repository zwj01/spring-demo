package com.soft.mongod.impl;

import com.soft.entity.LinkTrace;
import com.soft.mongod.LinkTraceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class LinkTraceDaoImpl implements LinkTraceDao {

    @Autowired
    private MongoTemplate template;

    @Override
    public void saveLinkTrace(LinkTrace linkTrace) {
        template.save(linkTrace);
    }
}

package com.soft.kafka.impl;

import com.soft.kafka.ConsumerLinkTraceDao;
import com.soft.pojo.LinkTracePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class ConsumerLinkTraceDaoImpl implements ConsumerLinkTraceDao {

    @Autowired
    private MongoTemplate template;

    @Override
    public void saveLinkTrace(LinkTracePojo linkTrace) {
        template.save(linkTrace);
    }
}

package com.soft.link;

import com.alibaba.fastjson.JSONObject;
import com.soft.entity.LinkTrace;
import com.soft.mongod.LinkTraceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerKafkaLink {

    @Autowired
    private LinkTraceDao linkTraceDao;

    @KafkaListener(topics = {"service.linktrace"})
    public void processMessage(String content) {
        JSONObject lobject = JSONObject.parseObject(content);
        LinkTrace linkTrace = JSONObject.toJavaObject(lobject,LinkTrace.class);
        linkTraceDao.saveLinkTrace(linkTrace);
        System.out.println("消息被消费"+linkTrace.toString());
    }
}

package com.soft.kafka;

import com.alibaba.fastjson.JSONObject;
import com.soft.pojo.LinkTracePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ConsumerKafkaLink {

    @Autowired
    private ConsumerLinkTraceDao linkTraceDao;

    @KafkaListener(topics = {"service.linktrace"})
    public void processMessage(String content) {
        JSONObject lobject = JSONObject.parseObject(content);
        LinkTracePojo linkTracePojo = JSONObject.toJavaObject(lobject,LinkTracePojo.class);
        //计算耗时
        //linkTrace.getReceiveTime()
        linkTracePojo.setTimeConsume(linkTracePojo.getSendTime() - linkTracePojo.getReceiveTime());
        linkTracePojo.setReqTime(new Date(linkTracePojo.getReceiveTime()));
        linkTraceDao.saveLinkTrace(linkTracePojo);
        System.out.println("消息被消费"+linkTracePojo.toString());
    }
}

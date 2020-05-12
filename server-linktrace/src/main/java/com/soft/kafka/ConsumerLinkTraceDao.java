package com.soft.kafka;

import com.soft.pojo.LinkTracePojo;

public interface ConsumerLinkTraceDao {

    void saveLinkTrace(LinkTracePojo linkTrace);
}

package com.soft.dao;

import com.soft.entity.LinkTrace;

import java.util.List;

public interface LinkTraceDao {

    /**
     * 根据参数查询链路信息
     * @param linkTrace
     * @return
     */
    List<LinkTrace> findLinkTrace(LinkTrace linkTrace);
}

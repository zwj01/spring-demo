package com.soft.dao;

import com.soft.entity.LinkTrace;

import java.util.List;
import java.util.Map;

public interface LinkTraceDao {

    /**
     * 根据traceid查询链路信息
     * @param linkTrace
     * @return
     */
    List<LinkTrace> findLinkTrace(LinkTrace linkTrace);

    /**
     * 根据参数查找链路信息
     * @param param
     * @return
     */
    List<LinkTrace> findLinkTraceByParam(Map param);

    List<LinkTrace> findLinkTraceByStatus(Integer status);
}

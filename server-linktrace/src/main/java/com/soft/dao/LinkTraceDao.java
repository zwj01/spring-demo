package com.soft.dao;

import com.soft.entity.LinkTrace;
import com.soft.pojo.LinkTracePojo;

import java.util.List;
import java.util.Map;

public interface LinkTraceDao {

    /**
     * 根据traceid查询链路信息
     * @param linkTrace
     * @return
     */
    List<LinkTracePojo> findLinkTrace(LinkTracePojo linkTracePojo);

    /**
     * 根据参数查找链路信息
     * @param param
     * @return
     */
    List<LinkTracePojo> findLinkTraceByParam(Map param);

    List<LinkTracePojo> findLinkTraceByStatus(Integer status);
}

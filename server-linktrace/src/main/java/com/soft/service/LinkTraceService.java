package com.soft.service;

import com.soft.entity.LinkTrace;
import com.soft.pojo.LinkTracePojo;

import java.util.List;
import java.util.Map;

public interface LinkTraceService {

    /**
     * 根据traceid查找链路信息
     * @param linkTrace
     * @return
     */
    List<LinkTracePojo> findLinkTrace(LinkTracePojo linkTrace);

    /**
     * 根据参数查找链路信息
     * @param param
     * @return
     */
    List<LinkTracePojo> findLinkTraceByParam(Map param);

    List<LinkTracePojo> findLinkTraceByStatus(Integer status);

    LinkTracePojo findLinkTraceBySpandId(LinkTracePojo linkTracePojo);
}

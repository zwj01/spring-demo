package com.soft.service.impl;

import com.soft.dao.LinkTraceDao;
import com.soft.entity.LinkTrace;
import com.soft.entity.TDInsideApi;
import com.soft.pojo.LinkTracePojo;
import com.soft.service.LinkTraceService;
import com.soft.service.TDInsideApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LinkTraceServiceImpl implements LinkTraceService {

    @Autowired
    TDInsideApiService tdInsideApiService;

    @Autowired
    LinkTraceDao linkTraceDao;

    @Override
    public List<LinkTracePojo> findLinkTrace(LinkTracePojo linkTrace) {
        return linkTraceDao.findLinkTrace(linkTrace);
    }

    @Override
    public List<LinkTracePojo> findLinkTraceByParam(Map param) {
        return linkTraceDao.findLinkTraceByParam(param);
    }

    @Override
    public List<LinkTracePojo> findLinkTraceByStatus(Integer status) {
        return linkTraceDao.findLinkTraceByStatus(status);
    }

    @Override
    public LinkTracePojo findLinkTraceBySpandId(LinkTracePojo linkTracePojo) {
        LinkTracePojo linkTracePojo1 = linkTraceDao.findLinkTrace(linkTracePojo).get(0);
        Map<String,Object> map = new HashMap<>();
        map.put("model",linkTracePojo1.getServiceName());
        map.put("api",linkTracePojo1.getUri());
        TDInsideApi tdInsideApi = tdInsideApiService.findTDInsideApi(map);
        linkTracePojo1.setTdInsideApi(tdInsideApi);
        return linkTracePojo1;
    }
}

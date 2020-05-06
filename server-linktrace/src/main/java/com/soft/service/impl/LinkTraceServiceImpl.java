package com.soft.service.impl;

import com.soft.dao.LinkTraceDao;
import com.soft.entity.LinkTrace;
import com.soft.service.LinkTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LinkTraceServiceImpl implements LinkTraceService {

    @Autowired
    LinkTraceDao linkTraceDao;

    @Override
    public List<LinkTrace> findLinkTrace(LinkTrace linkTrace) {
        return linkTraceDao.findLinkTrace(linkTrace);
    }

    @Override
    public List<LinkTrace> findLinkTraceByParam(Map param) {
        return linkTraceDao.findLinkTraceByParam(param);
    }

    @Override
    public List<LinkTrace> findLinkTraceByStatus(Integer status) {
        return linkTraceDao.findLinkTraceByStatus(status);
    }
}

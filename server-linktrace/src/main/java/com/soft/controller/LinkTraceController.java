package com.soft.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft.entity.LinkTrace;
import com.soft.service.LinkTraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/linktrace")
public class LinkTraceController {

    @Autowired
    LinkTraceService linkTraceService;

    @GetMapping(value = "/trace")
    public String getLinkTraceByTraceId(@RequestParam Integer traceId){
        LinkTrace linktrace = new LinkTrace();
        linktrace.setTraceId(traceId);
        List<LinkTrace> list = linkTraceService.findLinkTrace(linktrace);
        String result = JSONObject.toJSONString(list);
        return result;
    }
}

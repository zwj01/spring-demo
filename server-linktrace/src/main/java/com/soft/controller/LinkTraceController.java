package com.soft.controller;

import com.alibaba.fastjson.JSONObject;
import com.sofg.content.RestApi;
import com.sofg.pojo.ResponseBean;
import com.soft.entity.LinkTrace;
import com.soft.pojo.LinkTracePojo;
import com.soft.service.LinkTraceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/linktrace")
@Api(value = "LinkTrace Api接口", description = "RESTful API")
public class LinkTraceController {

    @Autowired
    LinkTraceService linkTraceService;

    @ApiOperation(value = "根据链路id获取链路信息",httpMethod = "POST",response = ResponseBean.class)
    @RequestMapping(value = "/trace",method=RequestMethod.POST)
    public ResponseBean getLinkTraceByTraceId(@RequestParam Integer traceId){
        LinkTracePojo linkTracePojo = new LinkTracePojo();
        linkTracePojo.setTraceId(traceId);
        List<LinkTracePojo> list = linkTraceService.findLinkTrace(linkTracePojo);
        String result = JSONObject.toJSONString(list);
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,list);
    }

    @ApiOperation(value = "根据Spanid获取链路信息",httpMethod = "POST",response = ResponseBean.class)
    @RequestMapping(value = "/span",method=RequestMethod.POST)
    public ResponseBean getLinkTraceBySpanId(@RequestParam Integer spanId){
        LinkTracePojo linkTracePojo = new LinkTracePojo();
        linkTracePojo.setSpandId(spanId);
        LinkTracePojo linkTracePojo1 = linkTraceService.findLinkTraceBySpandId(linkTracePojo);
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,linkTracePojo1);
    }

    @ApiOperation(value = "根据传入参数获取链路信息",httpMethod = "POST",response = ResponseBean.class)
    @RequestMapping(value = "/traces",method=RequestMethod.POST)
    public ResponseBean getLinkTraceByParam(@RequestBody Map param){
        Assert.notEmpty(param,"传参不能为空");
        List<LinkTracePojo> list = linkTraceService.findLinkTraceByParam(param);
        return  new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,list);
    }

    @ApiOperation(value = "根据链路状态链路信息",httpMethod = "POST",response = ResponseBean.class)
    @RequestMapping(value = "/strace",method=RequestMethod.POST)
    public ResponseBean getLinkTraceByStatus(@RequestParam Integer status){
        LinkTrace linktrace = new LinkTrace();
        List<LinkTracePojo> list = linkTraceService.findLinkTraceByStatus(status);
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,list);
    }
}

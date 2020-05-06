package com.soft.controller;

import com.alibaba.fastjson.JSONObject;
import com.sofg.content.RestApi;
import com.sofg.pojo.ResponseBean;
import com.soft.entity.LinkTrace;
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
        LinkTrace linktrace = new LinkTrace();
        linktrace.setTraceId(traceId);
        List<LinkTrace> list = linkTraceService.findLinkTrace(linktrace);
        String result = JSONObject.toJSONString(list);
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,list);
    }

    @ApiOperation(value = "根据传入参数获取链路信息",httpMethod = "POST",response = ResponseBean.class)
    @RequestMapping(value = "/traces",method=RequestMethod.POST)
    public ResponseBean getLinkTraceByParam(@RequestBody Map param){
        Assert.notEmpty(param,"传参不能为空");
        List<LinkTrace> list = linkTraceService.findLinkTraceByParam(param);
        return  new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,list);
    }

    @ApiOperation(value = "根据链路状态链路信息",httpMethod = "POST",response = ResponseBean.class)
    @RequestMapping(value = "/strace",method=RequestMethod.POST)
    public ResponseBean getLinkTraceByStatus(@RequestParam Integer status){
        LinkTrace linktrace = new LinkTrace();
        List<LinkTrace> list = linkTraceService.findLinkTraceByStatus(status);
        return new ResponseBean(RestApi.Msg.SUCCESS,RestApi.Code.SUCCESS,list);
    }
}

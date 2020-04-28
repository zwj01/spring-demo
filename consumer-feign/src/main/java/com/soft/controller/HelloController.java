package com.soft.controller;

import com.soft.bean.ResponseModel;
import com.soft.bean.SmallDto;
import com.soft.client.FHelloClient;
import com.soft.client.SmallClient;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;

/**
 * @author ZWJ
 * @date 2019/8/16 16:27
 * @Version 1.0
 **/
@EnableHystrix
@EnableCircuitBreaker
@EnableHystrixDashboard
@RestController
@Slf4j
@RequestMapping("/consumer")
public class HelloController {

    @Autowired
    FHelloClient fHelloClient;

    @Autowired
    SmallClient smallClient;

    @RequestMapping(value = "/get")
    public String hi(@RequestParam String name) {
        return fHelloClient.getHello(name);
    }

    @ApiOperation(value = "根据id初始化财务报表",httpMethod = "GET",response = SmallDto.class)
    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public ResponseModel<SmallDto> homeScreen(){
        try {
            log.info("userid");
            return new ResponseModel<>(HttpServletResponse.SC_OK,smallClient.homeScreen());

        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据userid获取主页面数据异常，参数:userid=>"  + "Exception:" + e.getMessage());
            return new ResponseModel<>(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"访问服务器错误！",null);
        }
    }

    @ApiOperation(value = "根据方案id获取图表配置信息",httpMethod = "GET",response = SmallDto.class)
    @RequestMapping(value = "/chart/{solutionid}",method = RequestMethod.GET)
    public ResponseModel<SmallDto> chartInformation(@PathVariable String solutionid){
        try {
            log.info("solutionid" + solutionid);
            return new ResponseModel<>(HttpServletResponse.SC_OK,smallClient.chartInformation(solutionid));

        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据solutionid获取方案配置信息异常，参数:solutionidd=>" + solutionid + "Exception:" + e.getMessage());
            return new ResponseModel<>(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"访问服务器错误。",null);
        }
    }

    @ApiOperation(value = "根据方案传入参数获取图表数据",httpMethod = "POST",response = SmallDto.class)
    @RequestMapping(value = "/getchart",method = RequestMethod.POST)
    public ResponseModel<SmallDto> chartData(@RequestBody Map map){
        try {
            log.info("map" + map);
            return new ResponseModel<>(HttpServletResponse.SC_OK,smallClient.chartData(map));

        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据传入参数map获取图表数据异常，参数:map=>" + map + "Exception:" + e.getMessage());
            return new ResponseModel<>(HttpServletResponse.SC_NO_CONTENT,"请求不到数据！",null);
        }
    }

    @ApiOperation(value = "根据方案传入参数获取表格数据",httpMethod = "POST",response = SmallDto.class)
    @RequestMapping(value = "/table",method = RequestMethod.POST)
    public ResponseModel<SmallDto> tableData(@RequestBody Map map){
        try {
            Instant old = Instant.now();
            log.info("map" + map);
            ResponseModel<SmallDto> responseModel = new ResponseModel<>(HttpServletResponse.SC_OK,smallClient.tableData(map));
            Instant to = Instant.now();
            System.out.println("执行时间："+ Duration.between(old, to).toMillis() + "毫秒。");
            return responseModel;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("根据传入参数map获取表格数据异常，参数:map=>" + map + "Exception:" + e.getMessage());
            return new ResponseModel<>(HttpServletResponse.SC_NO_CONTENT,"请求不到数据！",null);
        }
    }
}

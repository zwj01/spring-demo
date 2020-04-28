package com.soft.client;

import com.soft.bean.SmallDto;
import com.soft.client.hystrix.HelloService;
import com.soft.client.hystrix.SmallClientService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author ZWJ
 * @date 2019/8/21 16:18
 * @Version 1.0
 **/
@FeignClient(value = "sap-report-provider",fallback = SmallClientService.class)
@Component
public interface SmallClient {

    /**
     * 根据用户id 判断是否有权限  获取小程序主页面列表以及数据
     * @param
     * @return
     */
    @RequestMapping(value = "/api/small/init",method = RequestMethod.GET)
    SmallDto homeScreen();

    /**
     * 根据方案id，获取图表配置信息
     * @param solutionid
     * @return
     */
    @RequestMapping(value = "/api/small/chart/{solutionid}",method = RequestMethod.GET)
    SmallDto chartInformation(@PathVariable(value = "solutionid") String solutionid);

    /**
     * 根据参数，获取图表数据
     * @param map
     * @return
     */
    @RequestMapping(value = "/api/small/chart",method = RequestMethod.POST)
    SmallDto chartData(@RequestBody Map map);

    /**
     * 根据参数 获取table数据
     * @param map
     * @return
     */
    @RequestMapping(value = "/api/small/table",method = RequestMethod.POST)
    SmallDto tableData(@RequestBody Map map);
}

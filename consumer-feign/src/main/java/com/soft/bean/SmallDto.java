package com.soft.bean;

import lombok.Data;

import java.util.Map;

/**
 * @author ZWJ
 * @date 2019/8/21 16:21
 * @Version 1.0
 **/
@Data
public class SmallDto{

    /**
     * 返回调用接口信息
     */
    private Map message;

    /**
     * 返回模板信息
     */
    private Map template;

    /**
     * 返回事实数据
     */
    private Map data;

}

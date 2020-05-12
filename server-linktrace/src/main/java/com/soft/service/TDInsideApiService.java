package com.soft.service;

import com.soft.entity.TDInsideApi;

import java.util.Map;

public interface TDInsideApiService {

    /**
     * 根据模块名喝api查找网关接口信息
     * String model, String api
     * @param model
     * @param api
     * @return
     */
    TDInsideApi findTDInsideApi(Map<String,Object> params);
}

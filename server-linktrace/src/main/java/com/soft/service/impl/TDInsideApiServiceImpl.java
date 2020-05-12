package com.soft.service.impl;


import com.soft.dao.mybatis.TDInsideApiMapper;
import com.soft.entity.TDInsideApi;
import com.soft.service.TDInsideApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TDInsideApiServiceImpl implements TDInsideApiService {


    @Autowired
    TDInsideApiMapper tdInsideApiMapper;

    @Override
    public TDInsideApi findTDInsideApi(Map<String,Object> param) {
        return tdInsideApiMapper.findTDInsideApi(param);
    }
}

package com.soft.fund.service.impl;

import com.soft.fund.entity.FundHistoryData;
import com.soft.fund.entity.dao.FundHistoryDataMapper;
import com.soft.fund.entity.service.FundHistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "fundHistoryDataService")
public class FundHistoryDataServiceImpl implements FundHistoryDataService {

    @Autowired
    FundHistoryDataMapper fundHistoryDataMapper;

    @Override
    public int batchInsertFundHistoryData(List<FundHistoryData> fundHistoryDatas) {
        return fundHistoryDataMapper.batchInsertFundHistoryData(fundHistoryDatas);
    }
}

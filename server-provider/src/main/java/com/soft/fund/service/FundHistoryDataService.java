package com.soft.fund.service;

import com.soft.fund.entity.FundHistoryData;

import java.util.List;

public interface FundHistoryDataService {
    /**
     * 批量插入基金历史汇总数据
     * @param fundHistoryDatas
     * @return
     */
    int batchInsertFundHistoryData(List<FundHistoryData> fundHistoryDatas);
}

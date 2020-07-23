package com.soft.fund.dao;

import com.soft.fund.entity.FundHistoryData;

import java.util.List;

public interface FundHistoryDataMapper {

    /**
     * 批量插入基金历史汇总数据
     * @param fundHistoryDatas
     * @return
     */
    int batchInsertFundHistoryData(List<FundHistoryData> fundHistoryDatas);
}

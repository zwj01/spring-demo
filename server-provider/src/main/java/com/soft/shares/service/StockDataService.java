package com.soft.shares.service;

import com.soft.shares.entity.SearchParams;
import com.soft.shares.entity.StockDataDB;

import java.util.List;

public interface StockDataService {

    /**
     * 批量插入股票数据
     * @param stockDataDBs
     * @return
     */
    int batchInsertStockData(List<StockDataDB> stockDataDBs);

    /**
     * 根据传参获取股票信息
     * @param searchParams
     * @return
     */
    int getStockData(SearchParams searchParams);

    int getCollectionStockDataByTimeAndType(SearchParams searchParams);
}

package com.soft.shares.dao;

import com.soft.shares.entity.StockDataDB;

import java.util.List;

public interface StockDataMapper {

    /**
     * 批量插入股票数据
     * @param list
     * @return
     */
    int batchInsertStockData(List<StockDataDB> list);
}

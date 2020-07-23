package com.soft.shares.dao;

import com.soft.shares.entity.StockInfoDB;

import java.util.List;

public interface StockInfoMapper {

    /**
     * 批量插入股票代码信息
     * @param stockInfoDBList
     * @return
     */
    int batchInsertStockInfo(List<StockInfoDB> stockInfoDBList);

    /**
     * 根据参数获取股票代码信息
     * @param stockInfoDB
     * @return
     */
    List<StockInfoDB> getStockInfoDbList(StockInfoDB stockInfoDB);
}

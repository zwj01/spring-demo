package com.soft.shares.service;

import com.soft.shares.entity.StockInfoRequestDTO;

public interface StockInfoService {

    int readInfoFromResource(StockInfoRequestDTO stockInfoRequestDTO);
}

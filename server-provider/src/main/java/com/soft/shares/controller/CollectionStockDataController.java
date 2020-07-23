package com.soft.shares.controller;

import com.soft.shares.entity.SearchParams;
import com.soft.shares.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/collection")
public class CollectionStockDataController {

    @Autowired
    private StockDataService stockDataService;

    @RequestMapping(value = "/stockData",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String getCollectionStockData(@RequestBody SearchParams searchParams){
        stockDataService.getStockData(searchParams);
        return "成功";
    }

    @RequestMapping(value = "/stockDataT",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String getCollectionStockDataByTimeAndType(@RequestBody SearchParams searchParams){
        stockDataService.getCollectionStockDataByTimeAndType(searchParams);
        return "成功";
    }
}

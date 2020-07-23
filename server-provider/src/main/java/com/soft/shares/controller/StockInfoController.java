package com.soft.shares.controller;

import com.soft.shares.entity.StockInfoRequestDTO;
import com.soft.shares.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stockInfo")
public class StockInfoController {

    @Autowired
    private StockInfoService stockInfoService;

    @RequestMapping(value = "/readInfo",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String readStockInfoFromResources(@RequestBody StockInfoRequestDTO stockInfoRequestDTO){
        int num = stockInfoService.readInfoFromResource(stockInfoRequestDTO);
        System.out.println("插入成功数：" + num);
        return "成功";
    }


}

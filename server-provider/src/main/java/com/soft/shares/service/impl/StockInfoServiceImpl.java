package com.soft.shares.service.impl;

import com.soft.shares.dao.StockInfoMapper;
import com.soft.shares.entity.StockInfoDB;
import com.soft.shares.entity.StockInfoRequestDTO;
import com.soft.shares.service.StockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service(value = "stockInfoService")
public class StockInfoServiceImpl implements StockInfoService {

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Override
    public int readInfoFromResource(StockInfoRequestDTO stockInfoRequestDTO) {
        ClassPathResource resource = new ClassPathResource(stockInfoRequestDTO.getFile());
        int result=0;
        try {
            //StringBuilder sb = new StringBuilder();
            InputStream in = resource.getInputStream();
            BufferedReader str = new BufferedReader(new InputStreamReader(in));
            String s = str.readLine();
            List<StockInfoDB> stockInfoDBList = new ArrayList<>();
            String[] split = s.split(",");
            System.out.println(split.length);
            for (String ss : split){
                StockInfoDB stockInfoDB = new StockInfoDB();
                Integer index = ss.indexOf("(");
                String name = ss.substring(0,index);
                String code = ss.substring(index+1,ss.length() -1);
                stockInfoDB.setCompanyType(stockInfoRequestDTO.getCompanyType());
                stockInfoDB.setStockCode(code);
                stockInfoDB.setStockName(name);
                stockInfoDBList.add(stockInfoDB);
                System.out.println("名称：" + name + ";代码：" + code);
            }
            result = stockInfoMapper.batchInsertStockInfo(stockInfoDBList);
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}

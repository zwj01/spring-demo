package com.soft.shares.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.soft.shares.dao.StockDataMapper;
import com.soft.shares.dao.StockInfoMapper;
import com.soft.shares.entity.SearchParams;
import com.soft.shares.entity.StockDataDB;
import com.soft.shares.entity.StockInfoDB;
import com.soft.shares.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zwj
 */
@Service(value = "stockDataService")
public class StockDataServiceImpl implements StockDataService {

    @Autowired
    private StockInfoMapper stockInfoMapper;

    @Autowired
    private StockDataMapper stockDataMapper;

    @Override
    public int batchInsertStockData(List<StockDataDB> stockDataDBs) {
        int num = stockDataMapper.batchInsertStockData(stockDataDBs);
        return num;
    }



    @Override
    public int getStockData(SearchParams searchParams) {
        StringBuffer url = new StringBuffer();
        url.append("https://q.stock.sohu.com/hisHq?code=cn_").append(searchParams.getStockCode())
                .append("&start=").append(searchParams.getStart())
                .append("&end=").append(searchParams.getEnd())
                .append("&stat=").append(searchParams.getStat())
                .append("&order=").append(searchParams.getOrder())
                .append("&period=").append(searchParams.getPeriod())
                .append("&callback=historySearchHandler&rt=jsonp");
        List<StockDataDB> stockDataDBList = new ArrayList<>();
        try {
            URL ur = new URL(url.toString());
            BufferedReader reader = new BufferedReader(new InputStreamReader(ur.openStream(), "GBK"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("股票代码：" + searchParams.getStockCode());
                int start = line.indexOf("{");
                int end = line.indexOf("}");
                String after = line.substring(start, end + 1);
                JSONObject object = JSONObject.parseObject(after);
                String o = object.getString("hq");
                if (o != null){
                    System.out.println("o====================:" + o);
                    o = o.substring(1, o.length() - 2);
                    String[] stockDatas = o.split("],");

                    System.out.println("股票数据：" + o);
                    for (String s : stockDatas) {
                        s = s.substring(1);
                        System.out.println(s);
                        String[] stockData = s.split(",");
                        StockDataDB stockDataDB = new StockDataDB();
                        stockDataDB.setTransactionTime(interceptorStr(stockData[0]));
                        stockDataDB.setOpenPrice(interceptorStr(stockData[1]));
                        stockDataDB.setClosePrice(interceptorStr(stockData[2]));
                        stockDataDB.setUpDownPrice(interceptorStr(stockData[3]));
                        stockDataDB.setUpDownRange(interceptorStr(stockData[4]));
                        stockDataDB.setLowPrice(interceptorStr(stockData[5]));
                        stockDataDB.setHighPrice(interceptorStr(stockData[6]));
                        stockDataDB.setDealVolume(interceptorStr(stockData[7]));
                        stockDataDB.setDealMoney(interceptorStr(stockData[8]));
                        stockDataDB.setTurnoverRate(interceptorStr(stockData[9]));
                        stockDataDB.setStockCode(searchParams.getStockCode());
                        stockDataDBList.add(stockDataDB);
                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int num = 0;
        if (stockDataDBList.size() > 0){
            num = stockDataMapper.batchInsertStockData(stockDataDBList);
        }

        return num;
    }

    @Override
    public int getCollectionStockDataByTimeAndType(SearchParams searchParams) {
        StockInfoDB stockInfoDB = new StockInfoDB();
        stockInfoDB.setCompanyType(searchParams.getCompanyType());
        List<StockInfoDB> stockInfoDbList = stockInfoMapper.getStockInfoDbList(stockInfoDB);
        int count = 0;
        for (StockInfoDB sid : stockInfoDbList){
            searchParams.setStockCode(sid.getStockCode());
            int num = this.getStockData(searchParams);
            count = count + num;
        }
        System.out.println("插入条数，num:" + count);
        return count;
    }



    private String interceptorStr(String sourceStr){
       String  result = sourceStr.substring(1,sourceStr.length()-1);
        return  result;
    }
}

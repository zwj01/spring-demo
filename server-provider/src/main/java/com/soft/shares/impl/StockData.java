package com.soft.shares.impl;

import com.alibaba.fastjson.JSONObject;
import com.soft.shares.StockInterface;
import com.soft.shares.entity.StockDataDB;
import com.soft.shares.entity.TableSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class StockData implements StockInterface {

    public   String s;
    private int isNull=0;

    ObservableList<TableSet> tableData= FXCollections.observableArrayList();


    public int getIsNull(){
        return isNull;
    }
    public void setIsNull(){
        this.isNull = 1;
    }
    public void returnNull(){
        this.isNull = 0;
    }

    public StockData(String s) {
        this.s = s;
        prePare(s);
    }

    public StockData(){}

    //输入的字符串从这里进来，判断有多少组数据，再用循环去调用httpData
    public void prePare(String s){
        //统计要测几组数据
        String[] sourceArray = s.split(",");
        for(int i=0; i < sourceArray.length; i++){
            //http请求返回的数据
            String temp=httpData(sourceArray[i]);
            String array[]=convert(temp);
            if(array.length == 1){
                setIsNull();
            }else{
                addData(array);
            }
        }
    }

    @Override
    public String httpData(String httpArg) {
        String httpUrl = "http://hq.sinajs.cn/list=";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + httpArg;

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "GBK"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;


    }

    @Override
    public void addData(String[] s) {
        Calendar calendar=Calendar.getInstance();
        Date time = calendar.getTime();
        String recTime=(new SimpleDateFormat("HH:mm:ss")).format(time);
        String recDate=(new SimpleDateFormat("yyyy-MM-dd")).format(time);
        tableData.add(new TableSet(s[0],s[1],s[2],s[3],s[4],s[5],s[8],s[9],recDate,recTime));

    }

    public ObservableList<TableSet> getTableData(){
        return this.tableData;
    }

    public   String[] convert(String s){//将字符串解析为一个数组对应到参数当中
        String[] array;
        int begin=s.indexOf("\"");
        String temp=s.substring(begin+1,s.length());
        array = temp.split(",");
        return array;
    }






        public static void main(String[] args) {
            try {
                /*搜狐股票行情历史接口
                 * 说明：其中 code :股票代码，格式 国别_代码
                 * 		   period :数据周期（d表示日线，m表示月线，w表示周线）
                 * 		   order：排序方法（D表示降序排，A表示升序排）
                 * 		   stat=1代表合计，stat=0代表不合计；
                 * 返回的数据以这条为例"2018-07-20","61.22","61.83","0.61","1.00%","61.22","62.69","57637","35856.55","0.53%";
                 * 分别表示:                 日期，开盘，收盘，涨跌，涨幅，最低，最高，成交量，成交额，换手率。
                 * 【优点】1）有重要数据换手率;2）免费;3）封装简单;
                 * 【局限性】1）数据不是除权后的数据;2）一次最多只能读取100条交易记录;3）只能取日线、周线、月线数据;
                 */
                String url="https://q.stock.sohu.com/hisHq?code=cn_600677&start=20200715&end=20200717&stat=0&order=D&period=d&callback=historySearchHandler&rt=jsonp";
                //String url = "http://hq.sinajs.cn/list=sh601006";
                URL ur = new URL(url);
                BufferedReader reader = new BufferedReader(new InputStreamReader(ur.openStream(), "GBK"));
                String line;
                while ((line = reader.readLine()) != null) {

                    int start = line.indexOf("{");
                    int end = line.indexOf("}");
                    String after = line.substring(start,end+1);
                    JSONObject object = JSONObject.parseObject(after);
                    String o = object.getString("hq");
                    o = o.substring(1,o.length()-2);
                    String[] stockDatas = o.split("],");
                    List<StockDataDB> stockDataDBList = new ArrayList<>();
                    for (String s : stockDatas){
                        s = s.substring(1);
                        System.out.println(s);
                        String[] stockData = s.split(",");
                        StockDataDB stockDataDB = new StockDataDB();
                        stockDataDB.setTransactionTime(stockData[0]);
                        stockDataDB.setOpenPrice(stockData[1]);
                        stockDataDB.setClosePrice(stockData[2]);
                        stockDataDB.setUpDownPrice(stockData[3]);
                        stockDataDB.setUpDownRange(stockData[4]);
                        stockDataDB.setLowPrice(stockData[5]);
                        stockDataDB.setHighPrice(stockData[6]);
                        stockDataDB.setDealVolume(stockData[7]);
                        stockDataDB.setDealMoney(stockData[8]);
                        stockDataDB.setTurnoverRate(stockData[9]);
                        stockDataDB.setId(1);
                        stockDataDBList.add(stockDataDB);
                    }
                    System.out.println(stockDataDBList.size());
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }



}

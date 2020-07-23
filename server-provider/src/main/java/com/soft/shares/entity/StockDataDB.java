package com.soft.shares.entity;

/**
 * 股票数据-单日
 */
public class StockDataDB {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 交易时间
     */
    private String transactionTime;

    /**
     * 开盘价
     */
    private String openPrice;

    /**
     * 最高价
     */
    private String highPrice;

    /**
     * 最低价
     */
    private String lowPrice;

    /**
     * 收盘价
     */
    private String closePrice;

    /**
     * 涨跌幅
     */
    private String upDownRange;

    /**
     * 涨跌额
     */
    private String upDownPrice;

    /**
     * 成交量
     */
    private String dealVolume;

    /**
     * 成交额
     */
    private String dealMoney;

    /**
     * 换手率
     */
    private String turnoverRate;

    /**
     * 股票代码
     * @return
     */
    private String stockCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(String transactionTime) {
        this.transactionTime = transactionTime;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(String highPrice) {
        this.highPrice = highPrice;
    }

    public String getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(String lowPrice) {
        this.lowPrice = lowPrice;
    }

    public String getClosePrice() {
        return closePrice;
    }

    public void setClosePrice(String closePrice) {
        this.closePrice = closePrice;
    }

    public String getUpDownRange() {
        return upDownRange;
    }

    public void setUpDownRange(String upDownRange) {
        this.upDownRange = upDownRange;
    }

    public String getUpDownPrice() {
        return upDownPrice;
    }

    public void setUpDownPrice(String upDownPrice) {
        this.upDownPrice = upDownPrice;
    }

    public String getDealVolume() {
        return dealVolume;
    }

    public void setDealVolume(String dealVolume) {
        this.dealVolume = dealVolume;
    }

    public String getDealMoney() {
        return dealMoney;
    }

    public void setDealMoney(String dealMoney) {
        this.dealMoney = dealMoney;
    }

    public String getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(String turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    @Override
    public String toString() {
        return "StockDataDB{" +
                "id=" + id +
                ", transactionTime='" + transactionTime + '\'' +
                ", openPrice='" + openPrice + '\'' +
                ", highPrice='" + highPrice + '\'' +
                ", lowPrice='" + lowPrice + '\'' +
                ", closePrice='" + closePrice + '\'' +
                ", upDownRange='" + upDownRange + '\'' +
                ", upDownPrice='" + upDownPrice + '\'' +
                ", dealVolume='" + dealVolume + '\'' +
                ", dealMoney='" + dealMoney + '\'' +
                ", turnoverRate='" + turnoverRate + '\'' +
                '}';
    }
}

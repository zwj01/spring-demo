package com.soft.shares.entity;

public class SearchParams {

    /**
     * 股票代码
     */
    private String stockCode;

    /**
     * 开始时间
     */
    private String start;

    /**
     * 截止时间
     */
    private String end;

    /**
     * 是否合并
     */
    private String stat;

    /**
     * 数据周期
     */
    private String period;

    /**
     * 排序方式
     */
    private String order;

    /**
     * 公司类型
     */
    private String companyType;


   // {   "stockCode": "600588",   "start": "20200715",   "end": "20200717",   "stat": "0",   "period": "d",   "order": "D" }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}

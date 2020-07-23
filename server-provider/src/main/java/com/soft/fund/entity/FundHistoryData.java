package com.soft.fund.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 基金历史统计数据实体 表fund_history_data
 */
public class FundHistoryData {


    /**
     * 主键
     */
    private Integer id;
    /**
     * 基金代码
     */
    private String fundCode;
    /**
     * 基金简称
     */
    private String fundName;
    /**
     * 基金简称首字母
     */
    private String fundPy;
    /**
     * 汇总时间
     */
    private Date summaryDate;
    /**
     * 单位净值
     */
    private BigDecimal companyNetValue;
    /**
     * 累计净值
     */
    private BigDecimal cumulativeNetValue;
    /**
     * 日增长率
     */
    private BigDecimal growthRateDay;
    /**
     * 周增长率
     */
    private BigDecimal growthRateWeek;
    /**
     * 月增长率
     */
    private BigDecimal growthRateMonty;
    /**
     * 3个月增长率
     */
    private BigDecimal growthRateThreeMonty;
    /**
     * 6个月增长率
     */
    private BigDecimal growthRateSixMonty;
    /**
     * 年增长率
     */
    private BigDecimal growthRateYear;
    /**
     * 2年增长率
     */
    private BigDecimal growthRateTwoYear;
    /**
     * 3年增长率
     */
    private BigDecimal growthRateThreeYear;
    /**
     * 今年增长率
     */
    private BigDecimal growthRateThisYear;
    /**
     * 自成立以来
     */
    private BigDecimal growthRateEstablish;
    /**
     * 手续费
     */
    private BigDecimal transactionFee;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 基金类型
     */
    private String fundTyp;
    /**
     * 基金成立日期
     */
    private Date establishmentDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getFundPy() {
        return fundPy;
    }

    public void setFundPy(String fundPy) {
        this.fundPy = fundPy;
    }

    public Date getSummaryDate() {
        return summaryDate;
    }

    public void setSummaryDate(Date summaryDate) {
        this.summaryDate = summaryDate;
    }

    public BigDecimal getCompanyNetValue() {
        return companyNetValue;
    }

    public void setCompanyNetValue(BigDecimal companyNetValue) {
        this.companyNetValue = companyNetValue;
    }

    public BigDecimal getCumulativeNetValue() {
        return cumulativeNetValue;
    }

    public void setCumulativeNetValue(BigDecimal cumulativeNetValue) {
        this.cumulativeNetValue = cumulativeNetValue;
    }

    public BigDecimal getGrowthRateDay() {
        return growthRateDay;
    }

    public void setGrowthRateDay(BigDecimal growthRateDay) {
        this.growthRateDay = growthRateDay;
    }

    public BigDecimal getGrowthRateWeek() {
        return growthRateWeek;
    }

    public void setGrowthRateWeek(BigDecimal growthRateWeek) {
        this.growthRateWeek = growthRateWeek;
    }

    public BigDecimal getGrowthRateMonty() {
        return growthRateMonty;
    }

    public void setGrowthRateMonty(BigDecimal growthRateMonty) {
        this.growthRateMonty = growthRateMonty;
    }

    public BigDecimal getGrowthRateThreeMonty() {
        return growthRateThreeMonty;
    }

    public void setGrowthRateThreeMonty(BigDecimal growthRateThreeMonty) {
        this.growthRateThreeMonty = growthRateThreeMonty;
    }

    public BigDecimal getGrowthRateSixMonty() {
        return growthRateSixMonty;
    }

    public void setGrowthRateSixMonty(BigDecimal growthRateSixMonty) {
        this.growthRateSixMonty = growthRateSixMonty;
    }

    public BigDecimal getGrowthRateYear() {
        return growthRateYear;
    }

    public void setGrowthRateYear(BigDecimal growthRateYear) {
        this.growthRateYear = growthRateYear;
    }

    public BigDecimal getGrowthRateTwoYear() {
        return growthRateTwoYear;
    }

    public void setGrowthRateTwoYear(BigDecimal growthRateTwoYear) {
        this.growthRateTwoYear = growthRateTwoYear;
    }

    public BigDecimal getGrowthRateThreeYear() {
        return growthRateThreeYear;
    }

    public void setGrowthRateThreeYear(BigDecimal growthRateThreeYear) {
        this.growthRateThreeYear = growthRateThreeYear;
    }

    public BigDecimal getGrowthRateThisYear() {
        return growthRateThisYear;
    }

    public void setGrowthRateThisYear(BigDecimal growthRateThisYear) {
        this.growthRateThisYear = growthRateThisYear;
    }

    public BigDecimal getGrowthRateEstablish() {
        return growthRateEstablish;
    }

    public void setGrowthRateEstablish(BigDecimal growthRateEstablish) {
        this.growthRateEstablish = growthRateEstablish;
    }

    public BigDecimal getTransactionFee() {
        return transactionFee;
    }

    public void setTransactionFee(BigDecimal transactionFee) {
        this.transactionFee = transactionFee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFundTyp() {
        return fundTyp;
    }

    public void setFundTyp(String fundTyp) {
        this.fundTyp = fundTyp;
    }

    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }
}

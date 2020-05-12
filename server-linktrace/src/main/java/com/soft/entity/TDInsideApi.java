package com.soft.entity;

import java.util.Date;

/**
 * 内部网关Api接口登记信息
 * table  t_d_inside_api
 */
public class TDInsideApi {

    /**
     * 注册id
     */
    private Integer recId;
    /**
     * 请求地址
     */
  private String api;
    /**
     * 模块名称
     */
  private String model;
    /**
     * 操作类型 1:ADD,2:DEL,3:PUT,4:GET(增删改查)
     */
  private String operatorType;
    /**
     * 操作名称
     */
  private String operatorName;
    /**
     * api状态
     */
  private String status;
    /**
     * 备注信息
     */
  private String remake;
    /**
     * 创建人id
     */
  private Integer createMan;
    /**
     * 创建时间
     */
  private Date createTime;
    /**
     * 修改人id
     */
   private Integer modifyMan;
    /**
     * 修改时间
     */
  private Date modifyTime;

    public Integer getRecId() {
        return recId;
    }

    public void setRecId(Integer recId) {
        this.recId = recId;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getCreateMan() {
        return createMan;
    }

    public void setCreateMan(Integer createMan) {
        this.createMan = createMan;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getModifyMan() {
        return modifyMan;
    }

    public void setModifyMan(Integer modifyMan) {
        this.modifyMan = modifyMan;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}

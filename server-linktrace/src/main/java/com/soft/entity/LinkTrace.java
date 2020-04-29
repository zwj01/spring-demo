package com.soft.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 链路追踪信息  link_track
 * @author  zwj
 * @date 2020/4/13
 */
@Document(collection = "linktrace")
public class LinkTrace implements Serializable {

    /**
     * 追踪Id
     */
    private Integer traceId;
    /**
     * 跨度id
     */
     private Integer spandId;
    /**
     * 父跨度id
     */
    private Integer pSpanId;
    /**
     * 请求参数
     */
     private String params;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 发送时间
     */
     private Date sendTime;
    /**
     * 接收时间
     */
    private Date receiveTime;
    /**
     * 请求路径
     */
     private String uri;
    /**
     * API链
     */
    private String apiChain;
    /**
     * 请求Token
     */
     private String token;

    /**
     * 请求状态码
     */
    private Integer status;

    /**
     * 存储请求体
     */
    private String requestBody;

    /**
     * 存储响应数据
     */
    private String responseBody;

    public Integer getTraceId() {
        return traceId;
    }

    public void setTraceId(Integer traceId) {
        this.traceId = traceId;
    }

    public Integer getSpandId() {
        return spandId;
    }

    public void setSpandId(Integer spandId) {
        this.spandId = spandId;
    }

    public Integer getpSpanId() {
        return pSpanId;
    }

    public void setpSpanId(Integer pSpanId) {
        this.pSpanId = pSpanId;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getApiChain() {
        return apiChain;
    }

    public void setApiChain(String apiChain) {
        this.apiChain = apiChain;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "LinkTrace{" +
                "traceId=" + traceId +
                ", spandId=" + spandId +
                ", pSpanId=" + pSpanId +
                ", params='" + params + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", sendTime=" + sendTime +
                ", receiveTime=" + receiveTime +
                ", uri='" + uri + '\'' +
                ", apiChain='" + apiChain + '\'' +
                ", token='" + token + '\'' +
                ", status=" + status +
                ", requestBody='" + requestBody + '\'' +
                ", responseBody='" + responseBody + '\'' +
                '}';
    }
}

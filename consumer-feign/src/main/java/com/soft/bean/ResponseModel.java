package com.soft.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.soft.util.JsonUtils;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZWJ
 * @date 2019/8/21 16:36
 * @Version 1.0
 **/
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel<T> implements Serializable {
    private static final long serialVersionUID = -7878515977622749345L;
    private Integer status;
    private String msg;
    private T data;

    public ResponseModel(Integer status) {
        this.status = status;
    }

    public ResponseModel(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public ResponseModel(Integer code, String message, T data){
        this.status=code;
        this.data=data;
        this.msg=message;
    }
    public ResponseModel(Integer code, String message){
        this.status=code;
        this.msg=message;
    }

    public String toJson() {
        return JsonUtils.toJson(this);
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}


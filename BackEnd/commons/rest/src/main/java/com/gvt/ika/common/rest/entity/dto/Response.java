package com.gvt.ika.common.rest.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gvt.ika.shared.entity.constant.StatusCode;
import com.gvt.ika.shared.entity.dto.Code;

import java.io.Serializable;

public class Response<T> implements Serializable {

    private Integer status;
    private String message;
    private T payload;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getPayload() {
        return payload;
    }


    public void setPayload(T payload) {
        this.payload = payload;
    }

    @JsonIgnore
    public void setStatusAndMessageCode(Code code)
    {
        this.status = code.getStatus();
        this.message = code.getMessage();
    }

    public Response() {
        super();
    }

    public Response(Integer status, String message, T payload) {
        super();
        this.status = status;
        this.message = message;
        this.payload = payload;
    }

    public Response(Code code, T payload) {
        super();
        this.status = code.getStatus();
        this.message = code.getMessage();
        this.payload = payload;
    }


}

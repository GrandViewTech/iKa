package com.gvt.ika.common.rest.entity.dto;

public class Response<T> {

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

    public Response() {
        super();
    }

    public Response(Integer status, String message, T payload) {
        super();
        this.status = status;
        this.message = message;
        this.payload = payload;
    }


}

package com.gvt.ika.shared.entity.dto;

import java.io.Serializable;

public class Code implements Serializable {

    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Code() {
        super();
    }

    public Code(int status, String message) {
        this.message = message;
        this.status = status;
    }
}

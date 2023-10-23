package com.library.exception;

import java.util.Date;
import java.util.List;

public class ErrorResponseInformation {
    private int statusCode;
    private Date timestamp;
    private List<String> message;

    public ErrorResponseInformation(int statusCode, Date timestamp, List<String> message) {
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}

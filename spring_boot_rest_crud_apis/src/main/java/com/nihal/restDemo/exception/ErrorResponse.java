package com.nihal.restDemo.exception;

public class ErrorResponse {
    private String message;
    private long timeStamp;
    private int statusCode;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, long timeStamp, int statusCode) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

}

package com.wildfield.BulletinX.exception;

import java.time.LocalTime;

//Define what we like to write in error detail
public class ErrorDetail {
    private LocalTime timeStamp;
    private String message;
    private String details;

    public ErrorDetail(LocalTime timeStamp, String message, String details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

    public LocalTime getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}

package com.store.java.demo.exception;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ExceptionDetail {

    private String title;
    private LocalDateTime timestamp;
    private int status;
    private String exception;
    private HashMap<String, String> details;

    public ExceptionDetail(String title, LocalDateTime timestamp, int status, String exception, HashMap<String, String> details) {
        this.title = title;
        this.timestamp = timestamp;
        this.status = status;
        this.exception = exception;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public HashMap<String, String> getDetails() {
        return details;
    }

    public void setDetails(HashMap<String, String> details) {
        this.details = details;
    }
}
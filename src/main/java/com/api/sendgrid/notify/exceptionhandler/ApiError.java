package com.api.sendgrid.notify.exceptionhandler;
import org.springframework.http.HttpStatus;

public class ApiError {

    private HttpStatus status;
    private String message;

    private ApiError() {
    }



    public ApiError(HttpStatus status) {
        this();
        this.status = status;
        this.message = "Unexpected error";
    }

    public ApiError(HttpStatus status, String message) {
        this();
        this.status = status;
        this.message = message;
    }



    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



}

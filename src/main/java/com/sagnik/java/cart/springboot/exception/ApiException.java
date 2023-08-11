package com.sagnik.java.cart.springboot.exception;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {

    public ApiException(HttpStatus notFound, String s) {

    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String message;


}

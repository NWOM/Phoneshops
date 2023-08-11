package com.sagnik.java.cart.springboot.exception;

public class ErrorResponseDTO {
    private String message;

    public void setMessage(String message) {
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}

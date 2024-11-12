package com.mrp.exceptions;

public class ErrorResponse {

    private String message;

    // Construtor
    public ErrorResponse(String message) {
        this.message = message;
    }

    // Getter
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}

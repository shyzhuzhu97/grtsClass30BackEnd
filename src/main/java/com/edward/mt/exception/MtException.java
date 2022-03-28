package com.edward.mt.exception;

public class MtException extends RuntimeException {
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MtException(String message) {
        super(message);
        this.message = message;
    }
}

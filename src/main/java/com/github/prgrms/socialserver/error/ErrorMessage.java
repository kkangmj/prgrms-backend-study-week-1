package com.github.prgrms.socialserver.error;

public enum ErrorMessage {
    INVALID_FORMAT("invalid.format:");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(String target) {
        return "{" + message + target + "}";
    }
}

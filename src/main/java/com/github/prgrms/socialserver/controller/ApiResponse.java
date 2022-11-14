package com.github.prgrms.socialserver.controller;

public class ApiResponse<T> {

    private final T result;
    private final ApiError error;

    private ApiResponse(T result, ApiError error) {
        this.result = result;
        this.error = error;
    }

    public static <T> ApiResponse<T> OK(T result) {
        return new ApiResponse<>(result, null);
    }

    public static <T> ApiResponse<T> ERROR(String errorMessage) {
        return new ApiResponse<>(null, new ApiError(errorMessage));
    }

    public T getResult() {
        return result;
    }

    public ApiError getError() {
        return error;
    }
}

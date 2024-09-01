package com.turkcell.pair3.core.exception.types;

public class BusinessExceptionFactory {
    public static BusinessException createWithMessage(String message) {
        return new BusinessException(message);
    }
}

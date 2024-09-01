package com.turkcell.pair3.core.exception.factories;

import org.springframework.security.access.AccessDeniedException;

public class AccessDeniedExceptionFactory {
    public static AccessDeniedException createWithMessage(String message) {
        return new AccessDeniedException(message);
    }
}

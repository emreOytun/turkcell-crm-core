package com.turkcell.pair3.core.services;

import com.turkcell.pair3.core.exception.types.BusinessExceptionFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class CommonBusinessRules {
    public static <T> void checkIfListEmptyOrThrowExceptionWithMessage(List<T> list, String message) {
        if (CollectionUtils.isEmpty(list)) {
            throw BusinessExceptionFactory.createWithMessage(message);
        };
    }
}

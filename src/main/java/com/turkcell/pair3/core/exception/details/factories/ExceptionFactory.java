package com.turkcell.pair3.core.exception.details.factories;

import com.turkcell.pair3.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair3.core.exception.details.InternalProblemDetails;
import com.turkcell.pair3.core.exception.details.ValidationProblemDetails;
import org.springframework.security.access.AccessDeniedException;

public class ExceptionFactory {
    private ExceptionFactory() {

    }

    public static BusinessProblemDetails businessProblemDetails() {
        return new BusinessProblemDetails();
    }

    public static BusinessProblemDetails businessProblemDetails(String message) {
        BusinessProblemDetails businessProblemDetails = businessProblemDetails();
        businessProblemDetails.setDetail(message);
        return businessProblemDetails;
    }

    public static InternalProblemDetails internalProblemDetails() {
        return new InternalProblemDetails();
    }

    public static InternalProblemDetails internalProblemDetails(String message) {
        InternalProblemDetails internalProblemDetails = internalProblemDetails();
        internalProblemDetails.setDetail(message);
        return internalProblemDetails;
    }

    public static ValidationProblemDetails validationProblemDetails() {
        return new ValidationProblemDetails();
    }

    public static ValidationProblemDetails validationProblemDetails(String message) {
        ValidationProblemDetails validationProblemDetails = validationProblemDetails();
        validationProblemDetails.setDetail(message);
        return validationProblemDetails;
    }

    public static AccessDeniedException createWithMessage(String message) {
        return new AccessDeniedException(message);
    }
}

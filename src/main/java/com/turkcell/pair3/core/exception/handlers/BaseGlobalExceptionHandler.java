package com.turkcell.pair3.core.exception.handlers;

import com.turkcell.pair3.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair3.core.exception.details.ValidationProblemDetails;
import com.turkcell.pair3.core.exception.types.BusinessException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class BaseGlobalExceptionHandler
{
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BusinessProblemDetails handleBusinessException(BusinessException businessException)
    {
        BusinessProblemDetails problemDetails = new BusinessProblemDetails();
        problemDetails.setDetail(businessException.getMessage());
        return problemDetails;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationProblemDetails validationError = new ValidationProblemDetails();
        validationError.setDetail(methodArgumentNotValidException.getMessage());
        return validationError;
    }
}

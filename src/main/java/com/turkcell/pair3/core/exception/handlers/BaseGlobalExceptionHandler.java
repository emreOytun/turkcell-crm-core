package com.turkcell.pair3.core.exception.handlers;

import com.turkcell.pair3.core.exception.details.BusinessProblemDetails;
import com.turkcell.pair3.core.exception.details.InternalProblemDetails;
import com.turkcell.pair3.core.exception.details.ValidationProblemDetails;
import com.turkcell.pair3.core.exception.details.factories.ExceptionFactory;
import com.turkcell.pair3.core.exception.types.BusinessException;
import feign.FeignException;
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
        return ExceptionFactory.businessProblemDetails(businessException.getMessage());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        return ExceptionFactory.validationProblemDetails(methodArgumentNotValidException.getMessage());
    }

    @ExceptionHandler(FeignException.ServiceUnavailable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalProblemDetails handleFeignServiceUnavailable(FeignException.ServiceUnavailable ex) {
        return ExceptionFactory.internalProblemDetails();
    }

    @ExceptionHandler(FeignException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public InternalProblemDetails handleFeignException(FeignException ex) {
        return ExceptionFactory.internalProblemDetails();
    }
}

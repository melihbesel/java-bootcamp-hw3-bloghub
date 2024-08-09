package com.patika.bloghubpaymentservice.exception;

import com.patika.bloghubpaymentservice.dto.response.GenericResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogHubPaymentException.class)
    public GenericResponse handleBlogHubPaymentException(BlogHubPaymentException blogHubPaymentException){
        return GenericResponse.failed(blogHubPaymentException.getMessage());
    }

}

package com.patika.bloghubpaymentservice.exception;

import com.patika.bloghubpaymentservice.dto.response.GenericResponse;
import com.patika.bloghubpaymentservice.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final KafkaProducer kafkaProducer;

    @ExceptionHandler(BlogHubPaymentException.class)
    public GenericResponse handleBlogHubPaymentException(BlogHubPaymentException blogHubPaymentException){
        log.info("BlogHubPaymentException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(blogHubPaymentException.getMessage());
        return GenericResponse.failed(blogHubPaymentException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException exception){
        log.info("RuntimeException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(exception.getMessage());
        return exception.getMessage();
    }

}

package com.patika.bloghubuserservice.exception;

import com.patika.bloghubuserservice.dto.response.GenericResponse;
import com.patika.bloghubuserservice.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final KafkaProducer kafkaProducer;

    @ExceptionHandler(BlogHubUserException.class)
    public GenericResponse handleBlogHubUserException(BlogHubUserException blogHubUserException){
        log.info("BlogHubUserException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(blogHubUserException.getMessage());
        return GenericResponse.failed(blogHubUserException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException exception){
        log.info("RuntimeException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(exception.getMessage());
        return exception.getMessage();
    }

}

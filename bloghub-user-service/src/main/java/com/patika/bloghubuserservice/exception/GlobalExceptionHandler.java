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

    @ExceptionHandler(BlogHubException.class)
    public GenericResponse handleBlogHubException(BlogHubException blogHubException){
        log.info("ExceptionHandler çağrıldı");
        kafkaProducer.sendException(blogHubException.getMessage());
        return GenericResponse.failed(blogHubException.getMessage());
    }

}

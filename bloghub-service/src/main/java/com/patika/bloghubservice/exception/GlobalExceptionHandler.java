package com.patika.bloghubservice.exception;

import com.patika.bloghubservice.dto.response.GenericResponse;
import com.patika.bloghubservice.producer.KafkaProducer;
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
        log.info("BlogHubException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(blogHubException.getMessage());
        return GenericResponse.failed(blogHubException.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException exception){
        log.info("RuntimeException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(exception.getMessage());
        return exception.getMessage();
    }

}

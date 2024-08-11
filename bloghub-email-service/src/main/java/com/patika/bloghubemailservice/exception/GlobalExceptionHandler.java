package com.patika.bloghubemailservice.exception;

import com.patika.bloghubemailservice.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private final KafkaProducer kafkaProducer;

    @ExceptionHandler(BlogHubEmailException.class)
    public String handleBlogHubEmailException(BlogHubEmailException blogHubEmailException){
        log.info("BlogHubEmailException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(blogHubEmailException.getMessage());
        return blogHubEmailException.getMessage();
    }

    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException exception){
        log.info("RuntimeException ExceptionHandler çağrıldı");
        kafkaProducer.sendException(exception.getMessage());
        return exception.getMessage();
    }

}

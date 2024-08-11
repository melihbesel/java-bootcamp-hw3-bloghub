package com.patika.bloghubindexservice.service;

import com.patika.bloghubindexservice.model.Exception;
import com.patika.bloghubindexservice.repository.ExceptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    private final ExceptionRepository exceptionRepository;

    public void saveException(String message) {

        Exception exception = new Exception(message, LocalDateTime.now());

        exceptionRepository.save(exception);

        log.info("exception kaydedildi. exception: {}", exception);
    }
}

package com.patika.bloghubuserservice.producer;

import com.patika.bloghubuserservice.producer.constant.KafkaConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public final class KafkaProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendException(String message) {
        kafkaTemplate.send(KafkaConstants.BLOG_INDEX_TOPICS, message);
        log.info("exception kafka'ya gönderildi. topics:{}, message: {}", KafkaConstants.BLOG_INDEX_TOPICS, message);
    }

}

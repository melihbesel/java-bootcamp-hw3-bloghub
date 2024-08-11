package com.patika.bloghubindexservice.consumer;

import com.patika.bloghubindexservice.consumer.constant.KafkaConstants;
import com.patika.bloghubindexservice.service.KafkaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumer {

    private final KafkaService kafkaService;

    @KafkaListener(topics = KafkaConstants.BLOG_INDEX_TOPICS,
            groupId = KafkaConstants.BLOG_INDEX_GROUP_ID)
    public void listen(String message) {
        log.info("Received Message: {}", message);
        kafkaService.saveException(message);
    }
}

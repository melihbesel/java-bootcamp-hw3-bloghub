package com.patika.bloghubindexservice.consumer.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class KafkaConstants {
    public static final String BLOG_INDEX_TOPICS = "my-topic";
    public static final String BLOG_INDEX_GROUP_ID = "my-group";
}

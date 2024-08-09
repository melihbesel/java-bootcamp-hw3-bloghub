package com.patika.bloghubpaymentservice.producer;

import com.patika.bloghubpaymentservice.config.RabbitMQConfig;
import com.patika.bloghubpaymentservice.producer.dto.CreatePaymentMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMqProducer {

    private final AmqpTemplate rabbitTemplate;

    private final RabbitMQConfig rabbitMQConfig;

    public void createPayment(CreatePaymentMessage createPaymentMessage) {
        rabbitTemplate.convertAndSend(rabbitMQConfig.getExchange(), rabbitMQConfig.getRoutingkey(), createPaymentMessage);

        log.info("message kuyruğa gönderildi. kuyruk:{}, message: {}", rabbitMQConfig.getQueueName(), createPaymentMessage);

    }

}

package com.patika.bloghubuserservice.listener;

import com.patika.bloghubuserservice.dto.response.UserResponse;
import com.patika.bloghubuserservice.listener.dto.CreatePaymentMessage;
import com.patika.bloghubuserservice.listener.dto.enums.PaymentStatus;
import com.patika.bloghubuserservice.model.enums.UserType;
import com.patika.bloghubuserservice.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PaymentListener {

    private final UserService userService;

    @RabbitListener(queues = "${rabbitmq.payment.queue}")
    public void listenPayment(CreatePaymentMessage createPaymentMessage) {
        log.info("createPaymentMessage: {}", createPaymentMessage);
        if (createPaymentMessage.getPaymentStatus() == PaymentStatus.PAID) {
            UserResponse userResponse = userService.getUserByEmail(createPaymentMessage.getEmail());
            userService.changeType(userResponse.getEmail(), UserType.PREMIUM);
            log.info("Ödeme işlemi tamamlandıktan sonra kullanıcının statüsünü değişti. createPaymentMessage: {}", createPaymentMessage);
        }

    }
}

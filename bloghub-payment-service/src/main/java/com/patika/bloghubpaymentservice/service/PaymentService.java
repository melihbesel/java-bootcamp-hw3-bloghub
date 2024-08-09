package com.patika.bloghubpaymentservice.service;

import com.patika.bloghubpaymentservice.converter.PaymentConverter;
import com.patika.bloghubpaymentservice.dto.request.PaymentRequest;
import com.patika.bloghubpaymentservice.dto.response.PaymentResponse;
import com.patika.bloghubpaymentservice.exception.BlogHubPaymentException;
import com.patika.bloghubpaymentservice.exception.ExceptionMessages;
import com.patika.bloghubpaymentservice.model.PaymentStatus;
import com.patika.bloghubpaymentservice.producer.RabbitMqProducer;
import com.patika.bloghubpaymentservice.producer.dto.CreatePaymentMessage;
import com.patika.bloghubpaymentservice.repository.PaymentRepository;
import com.patika.bloghubpaymentservice.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final RabbitMqProducer rabbitMqProducer;

    public PaymentResponse createPayment(PaymentRequest request) {

        if (request.getAmount() == null) {
            log.error("request: {},", request + "\n" + ExceptionMessages.PAYMENT_AMOUNT_CAN_NOT_BE_EMPTY);
            throw new BlogHubPaymentException(ExceptionMessages.PAYMENT_AMOUNT_CAN_NOT_BE_EMPTY);
        }

        if (request.getEmail() == null) {
            log.error("request: {},", request + "\n" + ExceptionMessages.PAYMENT_EMAIL_CAN_NOT_BE_EMPTY);
            throw new BlogHubPaymentException(ExceptionMessages.PAYMENT_EMAIL_CAN_NOT_BE_EMPTY);
        }

        Payment payment = PaymentConverter.toEntity(request, PaymentStatus.PAID);

        paymentRepository.save(payment);

        rabbitMqProducer.createPayment(new CreatePaymentMessage(payment.getAmount(), payment.getCreatedDateTime(), payment.getPaymentStatus(), payment.getEmail()));

        return PaymentConverter.toResponse(payment);
    }

    public List<PaymentResponse> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();

        return PaymentConverter.toResponse(payments);
    }
}

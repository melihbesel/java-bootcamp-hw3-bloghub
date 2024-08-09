package com.patika.bloghubuserservice.listener.dto;

import com.patika.bloghubuserservice.listener.dto.enums.PaymentStatus;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreatePaymentMessage {

    private BigDecimal amount;
    private LocalDateTime createdDateTime;
    private PaymentStatus paymentStatus;
    private String email;

}

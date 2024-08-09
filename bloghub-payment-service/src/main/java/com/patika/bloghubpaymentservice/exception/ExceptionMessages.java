package com.patika.bloghubpaymentservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String PAYMENT_AMOUNT_CAN_NOT_BE_EMPTY = "ödeme miktarı boş gelemez";
    public static final String PAYMENT_EMAIL_CAN_NOT_BE_EMPTY = "email alanı boş gelemez";

}

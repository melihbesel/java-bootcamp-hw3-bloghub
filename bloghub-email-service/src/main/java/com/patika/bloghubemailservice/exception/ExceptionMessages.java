package com.patika.bloghubemailservice.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMessages {

    public static final String EMAIL_CAN_NOT_BE_EMPTY = "email boş gelemez";
    public static final String EMAIL_TEMPLATE_CAN_NOT_BE_EMPTY = "email template boş gelemez";

}

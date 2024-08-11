package com.patika.bloghubpaymentservice.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(name = "amount", description = "Ödeme miktarı", example = "9.99")
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "createdDateTime")
    private LocalDateTime createdDateTime;
    @Column(name = "paymentStatus")
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Column(name = "email")
    private String email;

    public Payment(BigDecimal amount, LocalDateTime createdDateTime, PaymentStatus paymentStatus, String email) {
        this.amount = amount;
        this.createdDateTime = createdDateTime;
        this.paymentStatus = paymentStatus;
        this.email = email;
    }

}

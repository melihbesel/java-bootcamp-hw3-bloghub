package com.patika.bloghubpaymentservice.repository;

import com.patika.bloghubpaymentservice.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

}

package com.patika.bloghubpaymentservice.controller;

import com.patika.bloghubpaymentservice.dto.request.PaymentRequest;
import com.patika.bloghubpaymentservice.dto.response.GenericResponse;
import com.patika.bloghubpaymentservice.dto.response.PaymentResponse;
import com.patika.bloghubpaymentservice.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping()
    @Operation(summary = "Ödeme oluşturur",
            description = "Ödeme eklemek için kullanılır."
    )
    public GenericResponse<PaymentResponse> createPayment(@RequestBody PaymentRequest request) {
        return GenericResponse.success(paymentService.createPayment(request), HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<List<PaymentResponse>> getAllPayments(){
        return GenericResponse.success( paymentService.getAllPayments(), HttpStatus.OK);
    }

}

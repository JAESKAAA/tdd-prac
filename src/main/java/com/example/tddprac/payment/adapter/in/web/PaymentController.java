package com.example.tddprac.payment.adapter.in.web;

import com.example.tddprac.payment.application.port.in.PaymentWriteUsecase;
import com.example.tddprac.payment.domain.dto.PaymentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentWriteUsecase paymentWriteUsecase;

    @PostMapping
    public ResponseEntity<Void> pay(@RequestBody PaymentRequest request) {
        paymentWriteUsecase.payment(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}

package com.example.tddprac.payment.application.port.in;

import com.example.tddprac.payment.domain.dto.PaymentRequest;

public interface PaymentWriteUsecase {

    void payment(PaymentRequest request);
}

package com.example.tddprac.payment.adapter.out.payment;

import com.example.tddprac.payment.application.port.out.PaymentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;


    @Override
    public void pay(int price, String cardNumber) {
        paymentGateway.execute(price, cardNumber);
    }
}

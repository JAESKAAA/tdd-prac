package com.example.tddprac.payment.adapter.out.payment;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void execute(int price, String cardNumber) {
        System.out.println("결제완료");
    }
}
